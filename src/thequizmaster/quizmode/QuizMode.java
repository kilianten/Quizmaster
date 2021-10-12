package thequizmaster.quizmode;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import thequizmaster.Constants;
import thequizmaster.Game;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.CountdownTimer;
import thequizmaster.questions.Question;

public class QuizMode {
	
	private String title;
	protected ArrayList<String> questionOptions;
	protected Question question;
	protected int questionSelected = 0;
	public boolean answeredCorrectly;
	protected boolean isAskingQuestion = true;
	public MainGame game;
	public boolean answered = false;
	public boolean gameRunning = true;
	protected CountdownTimer timer;
	protected Random random = new Random();
	private int knowledgeChanceRevealAnswer = 0;
	private boolean[] questionMapReveal = new boolean[4];

	protected Keyboard input;

	public QuizMode() {
		
	}

	public void start(){

	}

	public void getNewQuestion(){
		this.question = game.getQuestion(random.nextInt(5) + 1);
		questionOptions = question.getOptionsAnswer();
		questionSelected = 0;
		input.enterReleased = false;

		doesPlayerHaveKnowledge();
	}

	private void doesPlayerHaveKnowledge() {
		knowledgeChanceRevealAnswer = game.player.getKnowledge(question.getCategories());


		for(int i = 0; i < questionOptions.size(); i++){
			int randomChance = random.nextInt(100);
			if(knowledgeChanceRevealAnswer != 0 && randomChance < knowledgeChanceRevealAnswer){
				questionMapReveal[i] = true;
			} else {
				questionMapReveal[i] = false;
			}
		}
	}

	public QuizMode(MainGame game, Keyboard input) {
		input.enterReleased = false;
		this.input = input;
		this.game = game;
		getNewQuestion();
	}
	
	public void update() {
		if(gameRunning){
			if(answered) {
				if(answeredCorrectly){
					answeredCorrectlyResponse();
				} else {
					answeredIncorrectlyResponse();
				}
			} else {
				getPlayerInput();
			}
			if(timer != null){
				updateTimer();
			}
		}
		else {
			tidyUp();
		}
	}

	private void updateTimer() {
		if(timer.isFinished) {
			timerFinishedResponse();
		}
		timer.update();
	}

	private void timerFinishedResponse() {
		initialAnsweredIncorrectly();
		answeredIncorrectlyResponse();
	}

	public void answeredCorrectlyResponse(){
		game.givePlayerControl();
		game.quiz = null;
	}

	public void answeredIncorrectlyResponse(){
		gameRunning = false;
	}

	public void getPlayerInput(){
		if(isAskingQuestion) {
			if (input.upReleased) {
				input.upReleased = false;
				questionSelected--;
				if(questionSelected < 0) {
					questionSelected = question.getOptionsAnswer().size() - 1;
				}
			}
			if (input.downReleased) {
				input.downReleased = false;
				questionSelected++;
				questionSelected %= question.getOptionsAnswer().size();
			}
			if (input.enterReleased) {
				answeredCorrectly = isCorrectAnswer();
				if(!answeredCorrectly){
					initialAnsweredIncorrectly();
				}
				answered = true;
				input.enterReleased = false;
			}
		}
	}

	public void initialAnsweredIncorrectly(){
	}

	public void endGame() {
		
	}
	
	public boolean isCorrectAnswer() {
		return questionOptions.get(questionSelected) == question.getAnswer();
	}

	public void render(Screen screen) {

	}

	public void renderHUD(Screen screen, Graphics g) {
		if (!answered){
			drawQuestion(g);
		}
		if(timer != null){
			screen.renderFixedObject(5, 5, timer.sprite);
		}
	}
	
	public void drawQuestion(Graphics g) {
		if(!answered) {
			drawQuestionRects(g);
			drawQuestions(g);
		}
	}

	private void drawQuestions(Graphics g) {
		FontMetrics metrics = g.getFontMetrics(Game.digestFont);
		int yOffset = 0;
		g.setColor(Color.WHITE);

		String[] currentQuestion = question.getQuestion();
		for(int i = 0; i < currentQuestion.length; i++) {

			int x = 100 + (1000 - metrics.stringWidth(currentQuestion[i])) / 2;
			g.drawString(currentQuestion[i], x, 130 + (i * 20));

		}

		for(int i = 0; i < questionOptions.size(); i++) {
			g.setColor(Color.WHITE);
			if(questionMapReveal[i]) {
				if(questionOptions.get(i) == question.getAnswer()){
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.RED);
				}
			}
			g.drawString(questionOptions.get(i), 190, 300 + yOffset);
			yOffset += 120;
		}

		
	}
	
	public String[] SplitString(String text, FontMetrics metrics) {
		while(metrics.stringWidth(text) > 1000) {
			String temporary = " ";
			String nextString = " ";
			if(metrics.stringWidth(temporary + nextString) > 1000) {
				
			} else {
				
			}
		}
		return null;
	}

	private void drawQuestionRects(Graphics g) {
		int yOffset = 0;
		g.setColor(new Color(0xff523C52));
		g.fillRect(150, 100, 1000, 100);
		for(int i = 0; i < questionOptions.size(); i++) {
			if(i == questionSelected) {
				g.setColor(new Color(Constants.SELECTED_RECT_COLOR));
				g.fillRect(150 - Constants.questionSelectedPadding, 250 + yOffset - Constants.questionSelectedPadding, 1000 + Constants.questionSelectedPadding * 2, 100 + Constants.questionSelectedPadding * 2);
				g.setColor(new Color(0xff523C52));
			}
			g.fillRect(150, 250 + yOffset, 1000, 100);
			yOffset += 120;
		}
	}
	
	public void tidyUp() {
	}
}
