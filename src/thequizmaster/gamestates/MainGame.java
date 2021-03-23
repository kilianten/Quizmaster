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

public class MainGame extends GameState {

	private Player player;
	private LightSource light;
	private ArrayList<Player> people;
	private Level level;
	private Keyboard key;
	private boolean isQuizActive = false;
	
	public MainGame(Keyboard key) {
		this.key = key;
		level = new SpawnLevel("/levels/level01.png");
		people = new ArrayList<Player>();
		addPeople();
		player = new Douglas(key, level);
		light = new LightSource(500, player.x, player.y);
	}
	
	private void addPeople() {
		people.add(new Nolan(key, level));
	}
	
	public void checkCollidables() {
		for(int i = 0; i < level.gameObjects.size(); i++) {
			if(level.gameObjects.get(i).checkCollision(player.x, player.y, player.dir)) {
				isQuizActive = true;
				player.canMove = false;
				level.gameObjects.remove(i);
			}
		}
	}
	
	public void update() {
		key.update();
		player.update();
		level.update();
		checkCollidables();
		
		if(key.changePlayer) {
			if(!isQuizActive){
				swapPlayer();
			}
			key.changePlayer = false;
		}
	}
	
	public void render(Screen screen) {
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		
		level.render(xScroll, yScroll, screen);
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
