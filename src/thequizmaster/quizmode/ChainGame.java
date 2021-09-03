package thequizmaster.quizmode;

import thequizmaster.gamestates.MainGame;
import thequizmaster.level.Room;

public class ChainGame extends MainEvent {

	public ChainGame(Room room, MainGame game){
		super(room, game);
		gameName = "Chain Game";
		maxPlayers = 2;
		minWidth = 15;
		minHeight = 8;
		isAskingQuestion = true;
	}

	public void start(){
		game.player.x = 0;
		isGameEnded = true;
		game.quiz = null;
	}



}
