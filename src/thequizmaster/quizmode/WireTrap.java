package thequizmaster.quizmode;

import thequizmaster.graphics.Screen;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.questions.Question;

public class WireTrap extends QuizMode{
	
	private Question question;
	private CountdownTimer timer;

	public WireTrap(Question question) {
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswers().get(0));
		for(String option:question.getOptions()) {
			System.out.println(option);
		}
		timer = new CountdownTimer(1000);
	}
	
	public void renderHUD(Screen screen) {
		screen.renderFixedObject(5, 5, timer.sprite);
	}

	
}
