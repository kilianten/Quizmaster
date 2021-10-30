package thequizmaster.quizmode;


import thequizmaster.Constants;
import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.traps.TV;

public class SawChallenge extends MainEvent {

    public static int minWidth = 3;
    public static int minHeight = 3;
    private Player player;
    private int numberOfQuestions;
    private int questionsAnswered = 0;
    private TV tv;

    public SawChallenge(Keyboard input, Room room, MainGame game){
        super(input, room, game);
        gameName = "Difficulty Saw";
        isAskingQuestion = true;
        player = game.player;
        player.dir = 2;
        getDifficultQuestion(questionsAnswered + 1);
        createSawTrap();
        numberOfQuestions = random.nextInt(4) + 1;
        tv = new TV(room.topLeftCornerX + Constants.DEFAULT_SPRITE_SIZE, room.topLeftCornerY, game);
    }

    public void start(){
        isAskingQuestion = true;
    }

    public void tidyUp() {
        game.quiz = null;
        game.replaceCurrentPlayer();
        for(Player player: game.allPeople){
            player.animation = null;
        }
    }

    public void createSawTrap(){

    }

    public void answeredCorrectlyResponse(){
        answered = false;

        questionsAnswered++;
        if(questionsAnswered >= numberOfQuestions){
            playerWon();
        } else {
            tv.currentNumber++;
            getDifficultQuestion(questionsAnswered + 1);
        }
    }

    public void answeredIncorrectlyResponse(){
        gameRunning = false;
        game.player.animation = new Animation(1, game.player.chainGameDeath, game.player, 0, false);
    }

    public void playerWon() {
        player.y += 32;
        game.quiz = null;
    }

}

