package thequizmaster.quizmode;

import java.awt.Graphics;
import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.questions.Question;

public class WireTrap extends QuizMode{

	private Player player;
	private Animation deathAnimation;

	public WireTrap(Keyboard input, Player player, MainGame game) {
		super(game, input);
		timer = new CountdownTimer(30);
		this.player = player;
	}

	public void initialAnsweredIncorrectly(){
		deathAnimation = new Animation(.7, player.wireTrapDeathAnim, player, 10);
		player.dying = true;
	}

	public void answeredIncorrectlyResponse(){
		if(deathAnimation.isFinished) {
			tidyUp();
		} else {
			deathAnimation.update();
		}
	}
	
	public void tidyUp() {
		game.addDrawObject(new Corpse(player.x, player.y, player.wireTrapCorpse));
		game.quiz = null;
		player.killPlayer();
		game.replaceCurrentPlayer();
	}
	
	

	
}
