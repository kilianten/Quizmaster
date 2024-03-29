package thequizmaster.level.tile;

import java.util.Random;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class FloorTile extends Tile {
	
	public FloorTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}
	
}
