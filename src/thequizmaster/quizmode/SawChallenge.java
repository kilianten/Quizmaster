package thequizmaster.quizmode;


import thequizmaster.Constants;
import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.graphics.Sprite;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.Delay;
import thequizmaster.objects.traps.TV;

public class SawChallenge extends MainEvent {

    public static int minWidth = 3;
    public static int minHeight = 3;
    private Player player;
    private int numberOfQuestions;
    private int questionsAnswered = 0;
    private TV tv;
    private Delay delay;
    private boolean isTVNumberIncreased = false;

    public SawChallenge(Keyboard input, Room room, MainGame game){
        super(input, room, game);
        gameName = "Difficulty Saw";
        isAskingQuestion = true;
        player = game.player;
        player.dir = 2;
        player.y += 30;
        getDifficultQuestion(questionsAnswered + 1);
        createSawTrap();
        numberOfQuestions = random.nextInt(4) + 1;
        tv = new TV(room.topLeftCornerX + Constants.DEFAULT_SPRITE_SIZE, room.topLeftCornerY, game);
        player.animation = new Animation(.7, player.chainedSawChallengeAnim, player, 0, true);
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
        if(delay == null){
            delay = new Delay(2);
            isTVNumberIncreased = false;
        } else {
            delay.update();
        }
        if(delay.isFinished) {
            answered = false;
            questionsAnswered++;
            if (questionsAnswered >= numberOfQuestions) {
                playerWon();
            }
            else {

                getDifficultQuestion(questionsAnswered + 1);
            }
        } else if (!isTVNumberIncreased && delay.isHalfway){
            tv.currentNumber++;
            isTVNumberIncreased = true;
        }
    }

    public void answeredIncorrectlyResponse(){
        gameRunning = false;
        game.player.animation = new Animation(1, game.player.chainGameDeath, game.player, 0, false);
    }

    public void playerWon() {
        player.animation = null;
        game.quiz = null;
    }

}

