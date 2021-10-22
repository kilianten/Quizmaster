package thequizmaster.quizmode;


import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;
import thequizmaster.objects.Corpse;

public class SawChallenge extends MainEvent {

    public static int minWidth = 5;
    public static int minHeight = 4;
    private Player player;
    private int numberOfQuestions;
    private int questionsAnswered = 0;

    public SawChallenge(Keyboard input, Room room, MainGame game){
        super(input, room, game);
        gameName = "Difficulty Saw";
        isAskingQuestion = true;
        player = game.player;
        getDifficultQuestion(questionsAnswered + 1);
        createSawTrap();
        numberOfQuestions = random.nextInt(4) + 1;
        System.out.println("NUMBER OF QUESTIONS" + numberOfQuestions);
    }

    public void start(){
        isAskingQuestion = true;
    }

    public void tidyUp() {
        game.quiz = null;
        //player.killPlayer(player.chainGameDeath[22]);
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
            getDifficultQuestion(questionsAnswered + 1);
        }
    }

    public void answeredIncorrectlyResponse(){
        gameRunning = false;
        game.player.animation = new Animation(1, game.player.chainGameDeath, game.player, 0, false);
    }


}

