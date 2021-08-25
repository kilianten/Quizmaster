package thequizmaster.gamestates;

import java.awt.Graphics;
import java.util.ArrayList;

import thequizmaster.entity.mob.Player;
import thequizmaster.entity.mob.people.Douglas;
import thequizmaster.entity.mob.people.Nolan;
import thequizmaster.graphics.LightSource;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;
import thequizmaster.level.SpawnLevel;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.GameObject;
import thequizmaster.objects.Hitbox;
import thequizmaster.objects.hud.InventoryBar;
import thequizmaster.objects.hud.PoisonBar;
import thequizmaster.objects.items.CureSyringeSmall;
import thequizmaster.objects.items.Item;
import thequizmaster.questions.QuestionHandler;
import thequizmaster.quizmode.QuizMode;
import thequizmaster.quizmode.WireTrap;

public class MainGame extends GameState {

	private Player player;
	private LightSource light;
	private ArrayList<Player> people;
	private ArrayList<GameObject> drawObjects;
	private Level level;
	private Keyboard key;
	private boolean isQuizActive = false;
	private QuestionHandler questionHandler;
	public QuizMode quiz;
	private PoisonBar poisonBar;
	private InventoryBar inventoryBar;
	public String interactingMessage = "";

	public MainGame(Keyboard key) {
		questionHandler = new QuestionHandler();
		this.key = key;
		level = new SpawnLevel("/levels/level01.png");
		people = new ArrayList<Player>();
		drawObjects = new ArrayList<GameObject>();
		addPeople();
		player = new Douglas(key, level);
		player.currentPlayer = true;
		light = new LightSource(500, player.x, player.y);
		quiz = null;
		createHUD();
		createItem(player.x, player.y, "smallSyringe");
	}

	private void createHUD() {
		poisonBar = new PoisonBar();
		inventoryBar = new InventoryBar();
	}
	
	private void addPeople() {
		people.add(new Nolan(key, level));
	}
	
	public void checkCollidables() {
		for(int i = 0; i < level.collidableObjects.size(); i++) {
			if(Hitbox.isColliding(level.collidableObjects.get(i).hitbox, player.hitbox)) {
				level.collidableObjects.get(i).hasCollided(this);
			}
		}
		boolean foundInteractiveObject = false;
		for(int i = 0; i < level.interactablebjects.size(); i++) {
			if(Hitbox.isColliding(level.interactablebjects.get(i).hitbox, player.interactionBox)) {
				level.interactablebjects.get(i).hasCollided(this);
				foundInteractiveObject = true;

				if(player.isInteracting){
					level.interactablebjects.get(i).isInteractedWith(this);
				}
				break;
			}
		}
		if(!foundInteractiveObject){
			interactingMessage = "";
		}

	}

	public void removeGameObject(GameObject object){
		level.gameObjects.remove(object);
	}

	public void removeCollidableObject(GameObject object){
		level.collidableObjects.remove(object);
	}

	public void removeInteractableObject(GameObject object){
		level.interactablebjects.remove(object);
	}


	public void removePlayerControl() {
		isQuizActive = true;
		player.canMove = false;
	}

	public void createWireTrapQuiz(){
		quiz = new WireTrap(questionHandler.getQuestion(3), key, player);
	}

	private void givePlayerControl() {
		isQuizActive = false;
		player.canMove = true;
	}

	public void update() {
		key.update();
		checkCollidables();
		if(!(quiz == null)) {
			if(quiz.isFinished || quiz.answeredCorrectly) {
				quiz = null;
				givePlayerControl();
			}
			else {
				if(quiz.isGameEnded) {
					quiz.tidyUp(this);
				} else {
					quiz.update();
				}
			}
		} else {
			player.update();
			level.update();
		}
		
		if(key.changePlayer) {
			if(!isQuizActive){
				swapPlayer();
			}
			key.changePlayer = false;
		}
	}
	
	public void renderHUD(Screen screen, Graphics g) {
		if(!(quiz == null)) {
			quiz.renderHUD(screen, g);
		} else {
			poisonBar.render(screen, player.poisonLevel, player.HUDImage);
			inventoryBar.render(screen, player.playerSelection);
		}
	}
	
	public void render(Screen screen) {
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		
		level.render(xScroll, yScroll, screen);
		
		if(devMode) {
			for (int i = 0; i < level.collidableObjects.size(); i++) {
				screen.renderHitbox(level.collidableObjects.get(i).hitbox, 0xff00b300);
			}
			for (int i = 0; i < level.interactablebjects.size(); i++) {
				screen.renderHitbox(level.interactablebjects.get(i).hitbox, 0xffB200B2);
			}
		}
		
		for(Player person: people) {
			if(person.y < player.y) {
				person.render(screen);
			}
		}
		for(GameObject object: drawObjects) {
			if(object.y < player.y) {
				object.render(screen);
			}
		}
		
		player.render(screen);
		for(Player person: people) {
			if(person.y >= player.y) {
				person.render(screen);
			}
		}
		for(GameObject object: drawObjects) {
			if(object.y >= player.y) {
				object.render(screen);
			}
		}
	
		if(devMode) {
			screen.renderHitbox(player.hitbox, 0xff00b300);
			screen.renderHitbox(player.interactionBox, 0xffB200B2);
		}
	
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void swapPlayer() {
		if(people.size() > 0) {
			people.add(player);
			player.resetSprite();
			player.currentPlayer = false;
			player = people.get(0);
			player.currentPlayer = true;
			people.remove(player);
		}
	}
	
	public void replaceCurrentPlayer() {
		player = people.get(0);
		player.currentPlayer = true;
		people.remove(player);
	}

	public void addDrawObject(GameObject object) {
		drawObjects.add(object);
	}

	public void createItem (int x, int y, String type){
		Item item;
		switch(type) {
			case "smallSyringe":
				item = new CureSyringeSmall(x, y);
				break;
			default:
				item = new CureSyringeSmall(x, y);
				System.out.println("Item Type Not Recognised");
		}
		level.addGameObject(item);
		level.addInteractableObject(item);
	}

	public void setInteractingMessage(String message){
		interactingMessage = message;
	}

}
