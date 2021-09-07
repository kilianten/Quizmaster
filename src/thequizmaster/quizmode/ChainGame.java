package thequizmaster.quizmode;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.level.Room;
import thequizmaster.objects.traps.ChainGameSaw;

import java.util.ArrayList;
import java.util.Collections;

public class ChainGame extends MainEvent {

	public ChainGame(Room room, MainGame game){
		super(room, game);
		gameName = "Chain Game";
		maxPlayers = 2;
		minWidth = 15;
		minHeight = 8;
		isAskingQuestion = true;
		createSawTraps();
	}

	public void start(){
		isGameEnded = true;
		game.quiz = null;
	}

	public void createSawTraps(){
		ArrayList<Player> allPlayers = game.allPeople;
		Collections.shuffle(allPlayers);
		int sawOffsetX = 0;
		int sawYOffest = room.topLeftCornerY - 60;
		int test = 0;
		for(Player player: allPlayers){
			new ChainGameSaw(room.topLeftCornerX + sawOffsetX, sawYOffest, game);
			player.x = room.topLeftCornerX + sawOffsetX + 32;
			player.y = sawYOffest + 128 + test;
			sawOffsetX += 64;
		}

		for(Player player: allPlayers){
			System.out.println(player.fname);
		}
	}



}
