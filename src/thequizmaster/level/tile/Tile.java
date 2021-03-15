package thequizmaster.level.tile;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class Tile {

	private int x, y;
	private Sprite sprite;
	
	public static Tile floorTile = new FloorTile(Sprite.floorTile);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Sprite getSprite() {
		return sprite;
	}
	
	public boolean isSolid() {
		return false;
	}

	
}
