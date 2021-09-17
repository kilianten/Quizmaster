package thequizmaster.quizmode;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.objects.traps.ChainGameSaw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChainGame extends MainEvent {

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
		drawQuestion(g);
	}

	public void start(){
		isAskingQuestion = true;
	}



	public void createSawTraps(){
		ArrayList<Player> allPlayers = game.allPeople;
		Collections.shuffle(allPlayers);
		int sawOffsetX = 0;
		int sawYOffest = room.topLeftCornerY - 60;
		for(Player player: allPlayers){
			new ChainGameSaw(room.topLeftCornerX + sawOffsetX, sawYOffest, game);
			player.x = room.topLeftCornerX + sawOffsetX + 32;
			player.y = sawYOffest + 128;
			sawOffsetX += 64;
		}
	}



}
