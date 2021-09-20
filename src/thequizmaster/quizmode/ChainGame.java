package thequizmaster.quizmode;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.objects.traps.ChainGameSaw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ChainGame extends MainEvent {

	public int setBack = -1;
	public int delayCounter;
	public final int SETBACK_DELAY = 20;
	public int deathY;

	Random random = new Random();

	public ChainGame(Keyboard input, Room room, MainGame game){
		super(input, room, game);
		gameName = "Chain Game";
		maxPlayers = 2;
		minWidth = 15;
		minHeight = 8;
		isAskingQuestion = true;
		this.question = game.getQuestion(4);
		questionOptions = question.getOptionsAnswer();
		createSawTraps();
	}

	public void renderHUD(Screen screen, Graphics g) {
		if (!answered){
			drawQuestion(g);
		}
	}

	public void start(){
		isAskingQuestion = true;
	}

	public void tidyUp() {
		game.addDrawObject(new Corpse(game.player.x, game.player.y, game.player.wireTrapCorpse));
		game.quiz = null;
		game.player.killPlayer();
		game.replaceCurrentPlayer();
		for(Player player: game.allPeople){
			player.y += 32;
		}
	}

	public void createSawTraps(){
		ArrayList<Player> allPlayers = game.allPeople;
		Collections.shuffle(allPlayers);
		int sawOffsetX = 0;
		int sawYOffest = room.topLeftCornerY - 60;
		deathY = sawYOffest + 32;
		for(Player player: allPlayers){
			new ChainGameSaw(room.topLeftCornerX + sawOffsetX, sawYOffest, game);
			player.x = room.topLeftCornerX + sawOffsetX + 32;
			player.y = sawYOffest + 64;
			sawOffsetX += 64;
		}
	}

	public void answeredIncorrectlyResponse(){
		if(setBack == -1){
			setBack = random.nextInt(3) + 3;
			delayCounter = SETBACK_DELAY;
		}
		else if(setBack <= 0){
			game.swapPlayer();
			setBack = -1;
			answered = false;
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



}
