package thequizmaster.quizmode;

import thequizmaster.Game;
import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.traps.ChainGameLight;
import thequizmaster.objects.traps.ChainGameSaw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChainGame extends MainEvent {

	public int setBack = -1;
	public int delayCounter;
	public final int SETBACK_DELAY = 50;
	public int deathY;
	public int lightIndex;
	public static int minWidth = 15;
	public static int minHeight = 4;
	private int questionsToWin = 1;

	private ArrayList<ChainGameSaw> saws = new ArrayList<>();
	private ArrayList<ChainGameLight> lights = new ArrayList<>();

	public ChainGame(Keyboard input, Room room, MainGame game){
		super(input, room, game);
		game.setPlayersForward();
		game.setRandomPlayer();
		gameName = "Chain Game";
		maxPlayers = 2;
		isAskingQuestion = true;
		getNewQuestion();
		createSawTraps();
		questionsToWin += random.nextInt(5);
	}

	public void start(){
		isAskingQuestion = true;
	}

	public void tidyUp() {
		if(game.player.animation.isFinished){
			game.addAlwaysDrawOver(new Corpse(game.player.x, game.player.y, game.player.chainGameDeath[22], 1000));
			game.quiz = null;
			game.player.killPlayer(game.player.chainGameDeath[22]);
			game.replaceCurrentPlayer();
			for(Player player: game.allPeople){
				player.y += 32;
				player.animation = null;
			}
			for(ChainGameSaw saw: saws){
				game.removeUpdateObject(saw);
			}
			lightIndex = 1;
		}
	}

	public void createSawTraps(){
		ArrayList<Player> allPlayers = game.allPeople;
		Collections.shuffle(allPlayers);
		int sawOffsetX = 0;
		int sawYOffest = room.topLeftCornerY - 60;
		deathY = sawYOffest + 32;
		for(Player player: allPlayers){
			player.animation = new Animation(1, player.chainGameWaiting, player, random.nextInt(50), true);
			saws.add(new ChainGameSaw(room.topLeftCornerX + sawOffsetX, sawYOffest, game));
			player.movePlayer(room.topLeftCornerX + sawOffsetX + 32, sawYOffest + 54);
			sawOffsetX += 64;
			lights.add(new ChainGameLight(room.topLeftCornerX + sawOffsetX - 48, sawYOffest - 3, game, player));
		}
	}

	public void answeredCorrectlyResponse(){
		if(questionsToWin <= 1){
			playerWon();
		} else {
			questionsToWin--;
		}
		answered = false;
		for(ChainGameLight light: lights){
			if(light.player == game.player){
				toggleLightOfPlayer(false);
			}
		}
		game.swapPlayer();
		getNewQuestion();
	}

	public void answeredIncorrectlyResponse(){
		if(setBack == -1){
			setBack = random.nextInt(3) + 3;
			delayCounter = SETBACK_DELAY;
			toggleLightOfPlayer(true);
			game.player.animation = new Animation(1, game.player.chainGamePull, game.player, 0, true);
		}
		else if(setBack <= 0){
			toggleLightOfPlayer(false);
			game.player.animation = new Animation(1, game.player.chainGameWaiting, game.player, 0, true);
			game.swapPlayer();
			setBack = -1;
			answered = false;
			getNewQuestion();
		} else {
			if(delayCounter <= 0){
				delayCounter = SETBACK_DELAY;
				game.player.y -= 2;
				setBack--;
				if(game.player.y <= deathY){
					gameRunning = false;
					game.player.animation = new Animation(1, game.player.chainGameDeath, game.player, 0, false);
				}
			}
			delayCounter--;
		}
	}

	public void toggleLightOfPlayer(boolean turnOn){
		if(turnOn){
			for(ChainGameLight light: lights){
				if(light.player == game.player){
					light.turnOn();
				}
			}
		} else {
			for(ChainGameLight light: lights){
				if(light.player == game.player){
					light.turnOff();
				}
			}
		}
	}

	public void renderHUD(Screen screen, Graphics g) {
		super.renderHUD(screen, g);
		g.setColor(Color.WHITE);
		g.drawString("Correct Answers Until Free: " + questionsToWin, screen.width + 100,  30);
	}

	public void playerWon() {
		super.playerWon();
		for(ChainGameSaw saw: saws){
			game.removeUpdateObject(saw);
		}
	}

	public static boolean isRoomSuitable(Room room){
		if(room.width >= minWidth &&  room.height >= minHeight){
			return true;
		}
		else {
			return false;
		}
	}
}
