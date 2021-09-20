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

    private Player player;
    private Animation deathAnimation;

    public SearchBoxTrap(Question question, Keyboard input, Player player, MainGame game) {
        super(game, question, input);
        timer = new CountdownTimer(30);
        this.player = player;
    }

    public void renderHUD(Screen screen, Graphics g) {
        drawQuestion(g);
        screen.renderFixedObject(5, 5, timer.sprite);
    }

    public void answeredIncorrectlyResponse(){
        tidyUp();
    }

    public void answeredCorrectlyResponse(){
        player.y += 10;
        game.createRandomItem(player.x, player.y + 20);
        game.givePlayerControl();
        game.quiz = null;
    }

    public void tidyUp() {
        game.addDrawObject(new Corpse(player.x, player.y, player.wireTrapCorpse));
        game.quiz = null;
        player.killPlayer();
        game.replaceCurrentPlayer();
    }




}
