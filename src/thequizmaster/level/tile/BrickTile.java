package thequizmaster.level.tile;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class BrickTile extends Tile {
	
	public BrickTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}
	
}
