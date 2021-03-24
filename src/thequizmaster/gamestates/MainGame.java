package thequizmaster.gamestates;

import java.util.ArrayList;

import thequizmaster.entity.mob.Player;
import thequizmaster.entity.mob.people.Douglas;
import thequizmaster.entity.mob.people.Nolan;
import thequizmaster.graphics.LightSource;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;
import thequizmaster.level.SpawnLevel;
import thequizmaster.objects.Hitbox;
import thequizmaster.questions.QuestionHandler;
import thequizmaster.quizmode.QuizMode;
import thequizmaster.quizmode.WireTrap;

public class MainGame extends GameState {

	private Player player;
	private LightSource light;
	private ArrayList<Player> people;
	private Level level;
	private Keyboard key;
	private boolean isQuizActive = false;
	private QuestionHandler questionHandler;
	private QuizMode quiz;
	
	public MainGame(Keyboard key) {
		questionHandler = new QuestionHandler();
		this.key = key;
		level = new SpawnLevel("/levels/level01.png");
		people = new ArrayList<Player>();
		addPeople();
		player = new Douglas(key, level);
		light = new LightSource(500, player.x, player.y);
		quiz = null;
	}
	
	private void addPeople() {
		people.add(new Nolan(key, level));
	}
	
	public void checkCollidables() {
		for(int i = 0; i < level.collidableObjects.size(); i++) {
			if(Hitbox.isColliding(level.collidableObjects.get(i).hitbox, player.hitbox)) {
				isQuizActive = true;
				player.canMove = false;
				level.gameObjects.remove(i);
				level.collidableObjects.remove(i);
				quiz = new WireTrap(questionHandler.getQuestion(1));
			}
		}
	}
	
	public void update() {
		key.update();
		player.update();
		level.update();
		checkCollidables();
		if(!(quiz == null)) {
			quiz.update();
		}
		
		if(key.changePlayer) {
			if(!isQuizActive){
				swapPlayer();
			}
			key.changePlayer = false;
		}
	}
	
	public void renderHUD(Screen screen) {
		if(!(quiz == null)) {
			quiz.renderHUD(screen);
		}
	}
	
	public void render(Screen screen) {
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		
		level.render(xScroll, yScroll, screen);
		
		if(devMode) {
			for (int i = 0; i < level.collidableObjects.size(); i++) {
				screen.renderHitbox(level.collidableObjects.get(i).hitbox);
			}
		}
		
		for(Player person: people) {
			if(person.y < player.y) {
				person.render(screen);
			}
		}
		player.render(screen);
		for(Player person: people) {
			if(person.y >= player.y) {
				person.render(screen);
			}
		}
	
		if(devMode) {
			screen.renderHitbox(player.hitbox);
		}
	
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void swapPlayer() {
		people.add(player);
		player.resetSprite();
		player = people.get(0);
		people.remove(player);
	}
	
}
