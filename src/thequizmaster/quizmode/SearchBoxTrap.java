package thequizmaster.quizmode;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.CountdownTimer;

public class SearchBoxTrap extends QuizMode{

    private Player player;

    public SearchBoxTrap(Keyboard input, Player player, MainGame game) {
        super(game, input);
        timer = new CountdownTimer(30);
        this.player = player;
    }

    public void answeredIncorrectlyResponse(){
        tidyUp();
    }

    public void answeredCorrectlyResponse(){
        player.y += 10;
        game.createRandomItem(player.x, player.y + 25);
        game.givePlayerControl();
        game.quiz = null;
    }

    public void tidyUp() {
        game.addDrawObject(new Corpse(player.x, player.y, player.wireTrapCorpse));
        game.quiz = null;
        player.killPlayer(player.wireTrapCorpse);
        game.replaceCurrentPlayer();
    }




}
