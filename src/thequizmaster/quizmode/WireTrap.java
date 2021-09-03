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
	
	private CountdownTimer timer;
	private Player player;
	private Animation deathAnimation;

	public WireTrap(Question question, Keyboard input, Player player) {
		super(question, input);
		timer = new CountdownTimer(30);
		this.player = player;
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
		player.killPlayer();
		game.replaceCurrentPlayer();
	}
	
	

	
}
