package thequizmaster.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import thequizmaster.level.tile.Tile;

public class SpawnLevel extends Level {
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0,0, w, h, tiles, 0, w);
			randomizeFloorTiles();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception: Could not load level file at " + path);
		}
	}

	private void randomizeFloorTiles() {
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i] == 0XFFA4A4A7) {
				int randomTile = random.nextInt(200);
				if(randomTile <= 160) continue;
				else if(randomTile <= 165) tiles[i] = 2;
				else if(randomTile <= 170) tiles[i] = 3;
				else if(randomTile <= 175) tiles[i] = 4;
				else if(randomTile <= 180) tiles[i] = 5;
				else if(randomTile <= 185) tiles[i] = 6;
				else if(randomTile <= 190) tiles[i] = 7;
				else if(randomTile <= 195) tiles[i] = 8;
				else if(randomTile <= 200) tiles[i] = 9;
			}
		}
	}

	protected void generateLevel() {
		
	}

	private Tile getRandomFloorTile() {
		return Tile.floorTile;
	}
	
}
