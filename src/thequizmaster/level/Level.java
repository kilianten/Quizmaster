package thequizmaster.level;

import java.util.Random;

import thequizmaster.Constants;
import thequizmaster.graphics.Screen;
import thequizmaster.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	private Random random;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		random = new Random();
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	private void loadLevel(String path) {
		
	}

	protected void generateLevel() {
		
	}
	
	public void update() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll); //xScroll & yScroll is player location
		//render region of screen
		int x0 = xScroll >> 5; //xScrol / 32... get each tile rather than each pixel
		int x1 = (xScroll + screen.width + Constants.DEFAULT_SPRITE_SIZE) >> 5;
		int y0 = yScroll >> 5; //xScrol / 32... get each tile rather than each pixel
		int y1 = (yScroll + screen.height + Constants.DEFAULT_SPRITE_SIZE) >> 5;
		
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		int randomInt = random.nextInt(100);
		if(x < 0 || y < 0 || y >= height || x >= width) return Tile.voidTile;
		if(tiles[x + y * width] == 0) return Tile.floorTile;
		return Tile.voidTile;
	}
}