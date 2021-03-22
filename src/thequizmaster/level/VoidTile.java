package thequizmaster.level;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.level.tile.Tile;

public class VoidTile extends Tile {
	
	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}
	
}