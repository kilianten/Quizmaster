package thequizmaster.level;

import java.util.Random;

import thequizmaster.Constants;
import thequizmaster.graphics.Screen;
import thequizmaster.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	protected Random random;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		random = new Random();
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		random = new Random();
		loadLevel(path);
		
	}
	
	protected void loadLevel(String path) {
		
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
		if(x < 0 || y < 0 || y >= height || x >= width) return Tile.voidTile;
		if(tiles[x + y * width] == 0XFFA4A4A7) return Tile.floorTile;
		if(tiles[x + y * width] == 0XFFb34949) return Tile.brickTile;
		if(tiles[x + y * width] == 2) return Tile.floorTileStained01;
		if(tiles[x + y * width] == 3) return Tile.floorTileStained02;
		if(tiles[x + y * width] == 4) return Tile.floorTileStained03;
		if(tiles[x + y * width] == 5) return Tile.floorCracked01;
		if(tiles[x + y * width] == 6) return Tile.floorCracked02;
		if(tiles[x + y * width] == 7) return Tile.floorCracked03;
		if(tiles[x + y * width] == 8) return Tile.floorCracked04;
		if(tiles[x + y * width] == 9) return Tile.floorCracked05;
		if(tiles[x + y * width] == 1) return Tile.floorTileBlood;
		
		return Tile.voidTile;
	}
}