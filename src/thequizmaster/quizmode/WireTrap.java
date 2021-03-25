package thequizmaster.quizmode;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import thequizmaster.Game;
import thequizmaster.graphics.Screen;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.questions.Question;

public class WireTrap extends QuizMode{
	
	private Question question;
	private CountdownTimer timer;
	private ArrayList<String> questionOptions;

	public WireTrap(Question question) {
		this.question = question;
		questionOptions = question.getOptionsAnswer();
		timer = new CountdownTimer(13);
	}
	
	public void renderHUD(Screen screen, Graphics g) {
		//#BDCACD
		FontMetrics metrics = g.getFontMetrics(Game.digestFont);
		int yOffset = 0;
		for(int i = 0; i < questionOptions.size(); i++) {
			g.setColor(new Color(0xff523C52));
			g.fillRect(150, 250 + yOffset, 1000, 100);
			yOffset += 120;
		}
		yOffset = 0;
		for(int i = 0; i < questionOptions.size(); i++) {
			g.setColor(Color.WHITE);
			g.drawString(questionOptions.get(i), 190, 300 + yOffset);
			yOffset += 120;
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(150, 100, 1000, 100);
		
		g.setColor(new Color(0xff523C52));
		g.fillRect(150, 100, 1000, 100);
		g.setColor(Color.WHITE);
		int x = 100 + (1000 - metrics.stringWidth(question.getQuestion())) / 2;
		g.drawString(question.getQuestion(), x, 150);
		screen.renderFixedObject(5, 5, timer.sprite);
	}
	
	public void update() {
		if(timer.isFinished) {
			isFinished = true;
		}
		timer.update();
	}

	
}
