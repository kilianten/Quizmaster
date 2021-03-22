package thequizmaster.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import thequizmaster.level.tile.Tile;
import thequizmaster.objects.TripWire;

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
			alterMap(w, h);
			findRooms(w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception: Could not load level file at " + path);
		}
	}

	private void findRooms(int width) {
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i] == 0XFFb34949) {
				continue;
			}
		}
	}
	
	private void findMainRoom() {

	}

	private void alterMap(int width, int h) {
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i] == 0XFFA4A4A7) {
				int randomTile = random.nextInt(400);
				if(randomTile <= 350) continue;
				else if(randomTile == 351) tiles[i] = 1;
				else if(randomTile <= 355) tiles[i] = 7;
				else if(randomTile <= 360) tiles[i] = 8;
				else if(randomTile <= 365) tiles[i] = 9;
				else if(randomTile <= 370) tiles[i] = 5;
				else if(randomTile <= 375) tiles[i] = 6;
				else if(randomTile <= 380) tiles[i] = 4;
				else if(randomTile <= 390) tiles[i] = 3;
				else if(randomTile <= 400) tiles[i] = 2;
			}
			if(tiles[i] == 0XFFb34949 || tiles[i] == 0XFF7b3a3a) {
				if(tiles[i - width] == 0Xff000000) {
					tiles[i - width] = 0XFFb34949;
				}
				if(tiles[i + width] == 0XFFA4A4A7 && tiles[i + width * 2] == 0XFFA4A4A7 && tiles[i + width * 3] == 0XFFb34949) {
					TripWire trip = new TripWire(i % width * 32, i / width * 32 + 30);
					addGameObject(trip);
				}
			}
		}
	}

	protected void generateLevel() {
		
	}
	
}
