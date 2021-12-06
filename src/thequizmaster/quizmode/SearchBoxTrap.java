package thequizmaster.quizmode;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.objects.traps.ChainGameSaw;

public class SearchBoxTrap extends QuizMode{

    private Player player;

    public SearchBoxTrap(Keyboard input, Player player, MainGame game) {
        super(game, input);
        timer = new CountdownTimer(30);
        this.player = player;
        player.y += 3;
        player.animation = new Animation(.7, player.searchingBoxAnim, player, 0, true);
    }

    public void answeredIncorrectlyResponse(){
        gameRunning = false;
        player.animation = new Animation(.8, player.searchingBoxAnimDeath, player, 0, false);
    }

    public void answeredCorrectlyResponse(){
        player.y += 10;
        game.createRandomItem(player.x, player.y + 25);
        game.givePlayerControl();
        game.quiz = null;
        player.animation = null;
    }

    public void tidyUp() {
        if(game.player.animation.isFinished){
            game.addAlwaysDrawOver(new Corpse(player.x, player.y, player.searchingBoxAnimDeath[35]));
            game.quiz = null;
            player.killPlayer(game.player.searchingBoxAnimDeath[35]);
            game.replaceCurrentPlayer();
            player.animation = null;
        }
    }




}
