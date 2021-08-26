package thequizmaster.quizmode;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.questions.Question;

import java.awt.*;

public class SearchBoxTrap extends QuizMode{

    private CountdownTimer timer;
    private Player player;
    private Animation deathAnimation;
    private MainGame game;

    public SearchBoxTrap(Question question, Keyboard input, Player player, MainGame game) {
        super(question, input);
        timer = new CountdownTimer(30);
        this.player = player;
        this.game = game;
    }

    public void renderHUD(Screen screen, Graphics g) {
        drawQuestion(g);
        screen.renderFixedObject(5, 5, timer.sprite);
    }

    public void update() {
        super.update();
        if(isGameEnding) {
            endGame();
        }
        if (input.enterReleased) {
            input.enterReleased = false;
            if(!answeredCorrectly) {
                isGameEnding = true;
                deathAnimation = new Animation(.7, player.wireTrapDeathAnim, player, 10);
                player.dying = true;
                endGame();
            } else {
                game.createRandomItem(player.x, player.y + 20);
                //game.createItem(player.x, player.y + 20, "Small Syringe");
            }
        }
        if(timer.isFinished) {
            isFinished = true;
        }
        timer.update();
    }

    public void endGame() {
        if(deathAnimation.isFinished) {
            isGameEnded = true;
        } else {
            deathAnimation.update();
        }
    }

    public void tidyUp(MainGame game) {
        game.addDrawObject(new Corpse(player.x, player.y, player.wireTrapCorpse));
        game.quiz = null;
        game.replaceCurrentPlayer();
    }




}
