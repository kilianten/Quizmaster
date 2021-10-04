package thequizmaster.quizmode;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.traps.ChainGameLight;
import thequizmaster.objects.traps.ChainGameSaw;

import java.util.ArrayList;
import java.util.Collections;

public class ChainGame extends MainEvent {

	public int setBack = -1;
	public int delayCounter;
	public final int SETBACK_DELAY = 30;
	public int deathY;
	public int lightIndex;

	private ArrayList<ChainGameSaw> saws = new ArrayList<>();
	private ArrayList<ChainGameLight> lights = new ArrayList<>();

	public ChainGame(Keyboard input, Room room, MainGame game){
		super(input, room, game);
		game.setRandomPlayer();
		gameName = "Chain Game";
		maxPlayers = 2;
		minWidth = 15;
		minHeight = 8;
		isAskingQuestion = true;
		getNewQuestion();
		createSawTraps();
	}

	public void start(){
		isAskingQuestion = true;
		game.quiz = null;
	}

	public void tidyUp() {
		game.addDrawObject(new Corpse(game.player.x, game.player.y, game.player.wireTrapCorpse));
		game.quiz = null;
		game.player.killPlayer(game.player.wireTrapCorpse);
		game.replaceCurrentPlayer();
		for(Player player: game.allPeople){
			player.y += 32;
		}
		for(ChainGameSaw saw: saws){
			game.removeUpdateObject(saw);
		}
		lightIndex = 1;
	}

	public void createSawTraps(){
		ArrayList<Player> allPlayers = game.allPeople;
		Collections.shuffle(allPlayers);
		int sawOffsetX = 0;
		int sawYOffest = room.topLeftCornerY - 60;
		deathY = sawYOffest + 32;
		for(Player player: allPlayers){
			saws.add(new ChainGameSaw(room.topLeftCornerX + sawOffsetX, sawYOffest, game));
			player.x = room.topLeftCornerX + sawOffsetX + 32;
			player.y = sawYOffest + 54;
			sawOffsetX += 64;
			lights.add(new ChainGameLight(room.topLeftCornerX + sawOffsetX - 48, sawYOffest - 3, game, player));
		}
	}

	public void answeredCorrectlyResponse(){
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
		}
		else if(setBack <= 0){
			toggleLightOfPlayer(false);
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
					tidyUp();
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


}
