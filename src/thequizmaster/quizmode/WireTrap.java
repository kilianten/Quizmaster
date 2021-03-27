package thequizmaster.quizmode;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import thequizmaster.Game;
import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.questions.Question;

public class WireTrap extends QuizMode{
	
	private CountdownTimer timer;
	private Player player;
	private Animation deathAnimation;

	public WireTrap(Question question, Keyboard input, Player player) {
		super(question, input);
		timer = new CountdownTimer(20000);
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
				deathAnimation = new Animation(.5, player.wireTrapDeathAnim, player, 10);
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
		System.out.println("ENDGAME METHOD");
		if(deathAnimation.isFinished) {
			isGameEnded = true;
		} else {
			deathAnimation.update();

		}
	}
	
	public void tidyUp(MainGame game) {
		game.quiz = null;
		game.replaceCurrentPlayer();
	}
	
	

	
}
