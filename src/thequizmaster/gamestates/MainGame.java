package thequizmaster.gamestates;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import thequizmaster.Constants;
import thequizmaster.entity.mob.Player;
import thequizmaster.entity.mob.people.Douglas;
import thequizmaster.entity.mob.people.Karl;
import thequizmaster.entity.mob.people.Nolan;
import thequizmaster.gamestates.GameState;
import thequizmaster.gamestates.menus.InfoMenu;
import thequizmaster.gamestates.menus.Menu;
import thequizmaster.graphics.Animation;
import thequizmaster.graphics.LightSource;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;
import thequizmaster.level.SpawnLevel;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.GameObject;
import thequizmaster.objects.Hitbox;
import thequizmaster.objects.hud.InventoryBar;
import thequizmaster.objects.hud.PoisonBar;
import thequizmaster.objects.items.*;
import thequizmaster.objects.traps.SearchBox;
import thequizmaster.questions.Question;
import thequizmaster.questions.QuestionHandler;
import thequizmaster.quizmode.QuizMode;
import thequizmaster.quizmode.SearchBoxTrap;
import thequizmaster.quizmode.WireTrap;

public class MainGame extends GameState {


	private Random random;

	public Player player;
	private LightSource light;
	public ArrayList<Player> people;
	public ArrayList<Player> allPeople;
	public ArrayList<Player> allPeopleNeverChange;
	private ArrayList<GameObject> drawObjects;
	private ArrayList<GameObject> drawOverObjects;
	private ArrayList<GameObject> updateObjects;
	public Level level;
	public Keyboard key;
	private QuestionHandler questionHandler;
	public QuizMode quiz;
	public InfoMenu infoMenu;


	private PoisonBar poisonBar;
	private InventoryBar inventoryBar;

	public Menu menu;
	public String interactingMessage = "";

	public MainGame(Keyboard key) {
		questionHandler = new QuestionHandler();
		this.key = key;
		people = new ArrayList<>();
		drawObjects = new ArrayList<>();
		updateObjects = new ArrayList<>();
		allPeople = new ArrayList<>();
		allPeopleNeverChange = new ArrayList<>();
		drawOverObjects = new ArrayList<>();
		addPeople();
		player = new Douglas(key, this);
		player.currentPlayer = true;
		allPeople.add(player);
		allPeopleNeverChange.add(player);

		random = new Random();

		light = new LightSource(500, player.x, player.y);
		level = new SpawnLevel("/levels/level01.png", this);
		quiz.start();
		createHUD();
		createRandomItem(player.x, player.y);
		createRandomItem(player.x + 20, player.y + 20);
		createSearchBox(player.x - 100, player.y + 50);
	}

	private void createSearchBox(int x, int y) {
		CollidableObject object = new SearchBox(x, y);
		level.addGameObject(object);
		addDrawObject(object);
		level.addInteractableObject(object);
		level.addCollidableObject(object);
	}

	private void createHUD() {
		poisonBar = new PoisonBar();
		inventoryBar = new InventoryBar();
		infoMenu = new InfoMenu(this, key);
	}
	
	private void addPeople() {
		Player[] players = new Player[8];
		players[0] = new Nolan(key, this);
		players[1] = new Karl(key, this);

		for(Player p: players){
			if(p != null){
				addPlayerToGame(p);
			}
		}
	}

	private void addPlayerToGame(Player p) {
		allPeople.add(p);
		allPeopleNeverChange.add(p);
		people.add(p);
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

				if(player.input.interacting){
					level.interactablebjects.get(i).isInteractedWith(this);
					player.input.interacting = false;
				}
				break;
			}
		}
		player.input.interacting = false;
		if(!foundInteractiveObject){
			interactingMessage = "";
		}

	}

	public GameObject isSpecficObjectColliding(Hitbox hitbox, String objectType) {
		for(int i = 0; i < level.collidableObjects.size(); i++) {
			if(Hitbox.isColliding(level.collidableObjects.get(i).hitbox, hitbox) && level.collidableObjects.get(i).objectType == objectType) {
				return level.collidableObjects.get(i);
			}
		}
		return null;
	}

	public void removeGameObject(GameObject object){
		level.gameObjects.remove(object);
	}

	public void removeCollidableObject(GameObject object){
		level.collidableObjects.remove(object);
	}

	public void removeDrawOverObject(GameObject object){
		drawOverObjects.remove(object);
	}


	public void removeInteractableObject(GameObject object){
		level.interactablebjects.remove(object);
	}


	public void removePlayerControl() {
		player.canMove = false;
	}

	public void createWireTrapQuiz(){
		quiz = new WireTrap(key, player, this);
	}

	public void createSearchBoxTrapQuiz(){
		quiz = new SearchBoxTrap(key, player, this);
	}

	public void givePlayerControl() {
		player.canMove = true;
	}

	public void update() {
		key.update();
		checkInput();
		checkCollidables();
		for(GameObject object: updateObjects){
			object.update();
		}
		if(!(quiz == null)) {
			quiz.update();
			for(Player person: allPeople){
				person.animatePlayer();
			}
		}
		else if (menu != null){
			menu.update();
		}
		else {
			for(Player person: allPeople){
				person.animatePlayer();
			}
			player.update();
			level.update();
		}
		
		if(key.changePlayer) {
			if(quiz == null){
				if(menu == null){
					swapPlayer();
				} else {
					menu.swapPlayer();
				}
			}
			key.changePlayer = false;
		}
	}

	private void checkInput() {
		checkMenuInput();
	}

	public void renderHUD(Screen screen, Graphics g) {
		if(!(quiz == null)) {
			quiz.renderHUD(screen, g);
		}  else if (menu != null) {
			menu.render(screen, g);
		} else {
			poisonBar.render(screen, player.poisonLevel, player.HUDImage);
			inventoryBar.render(screen);
			player.renderItems(screen);
			inventoryBar.renderSelected(screen, player.playerSelection);
		}
	}

	public void renderHUDTEXT(Graphics g) {
		if (menu != null) {
			menu.renderHUDTEXT(g);
		} else {

		}
	}

	private void checkMenuInput(){
		if (key.wantsBioMenu){
			if(menu == null){
				menu = infoMenu;
			} else {
				menu = null;
			}
			key.wantsBioMenu = false;
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

		drawObjectsAndPlayers(screen);
	
		if(devMode) {
			screen.renderHitbox(player.hitbox, 0xff00b300);
			screen.renderHitbox(player.interactionBox, 0xffB200B2);
		}
	
	}

	private void drawObjectsAndPlayers(Screen screen) {
		Collections.sort(allPeople);
		Collections.sort(drawObjects);


		int peopleSize = allPeople.size();
		int peopleIndex = 0;
		int objectIndex = 0;
		int currentObjectY = drawObjects.get(objectIndex).y;
		int objectsSize = drawObjects.size();

		for(GameObject object: drawOverObjects){
			object.render(screen);
		}

		while(peopleIndex < peopleSize){
			while(currentObjectY <= allPeople.get(peopleIndex).y && objectIndex < objectsSize){
				drawObjects.get(objectIndex).render(screen);
				objectIndex++;
				if(objectIndex < objectsSize){
					currentObjectY = drawObjects.get(objectIndex).y;
				}
			}
			allPeople.get(peopleIndex).render(screen);
			peopleIndex++;
		}

		while(objectIndex < objectsSize){
			drawObjects.get(objectIndex).render(screen);
			objectIndex++;
		}




	}

	public Player getPlayer() {
		return player;
	}

	public void removeAsCurrentPlayer(Player p){
		people.add(p);
		p.resetSprite();
		p.currentPlayer = false;
		if(p.idleAnims != null){
			p.animation = new Animation(1.7, player.idleAnims[player.dir], player, 0, true);
		}
	}

	public void addAsCurrentPlayer(Player p){
		player = p;
		player.currentPlayer = true;
		people.remove(player);
		p.animation = null;
	}

	public void setRandomPlayer(){
		removeAsCurrentPlayer(player);
		int randomNum = random.nextInt(people.size());
		addAsCurrentPlayer(people.get(randomNum));
	}
	
	public void swapPlayer() {
		if(people.size() > 0) {
			removeAsCurrentPlayer(player);
			addAsCurrentPlayer(people.get(0));
		}
	}
	
	public void replaceCurrentPlayer() {
		allPeople.remove(player);
		player = people.get(0);
		player.currentPlayer = true;
		people.remove(player);
	}

	public void addDrawObject(GameObject object) {
		drawObjects.add(object);
	}

	public void addUpdateObject(GameObject object) {
		updateObjects.add(object);
	}

	public Item getItem(String type, int x, int y){
		Item item;
		switch(type) {
			case "Small Syringe":
				item = new CureSyringeSmall(x, y, this);
				break;
			case "Large Syringe":
				item = new CureSyringeLarge(x, y, this);
				break;
			case "Mystery Syringe":
				item = new MysterySyringe(x, y, this);
				break;
			case "Poison Syringe":
				item = new PoisonSyringe(x, y, this);
				break;
			case "Wirecutters":
				item = new Wirecutters(x, y, this);
				break;
			default:
				item = new Book(Book.getRandomCategory(), x, y, this);
		}

		return item;
	}

	public void createItem (int x, int y, String type){
		Item item = getItem(type, x, y);

		level.addGameObject(item);
		level.addInteractableObject(item);
	}

	public void createRandomItem(int x, int y){
		String stringItem = Item.getRandomItem();
		Item item = getItem(stringItem, x, y);
		level.addGameObject(item);
		level.addInteractableObject(item);
	}

	public void setInteractingMessage(String message){
		interactingMessage = message;
	}

	public void givePlayerItem(Item item){
		Item previousItem = player.giveItem(item);
		if(previousItem != null){
			level.addGameObject(previousItem);
			level.addInteractableObject(previousItem);
		}
	}

	public void addAlwaysDrawOver(GameObject object) {
		drawOverObjects.add(object);
	}

	public Question getQuestion(int difficulty){
		return questionHandler.getQuestion(difficulty);
	}

	public void removeUpdateObject(GameObject object) {
		updateObjects.remove(object);
	}
}
