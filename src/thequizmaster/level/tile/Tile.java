package thequizmaster.level.tile;

import thequizmaster.Constants;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public class Tile {

	private int x, y;
	public Sprite sprite;
	
	public static Tile floorTile = new FloorTile(Sprite.floorTile);
	public static Tile floorTileStained01 = new FloorTile(Sprite.floorTileStained01);
	public static Tile floorTileStained02 = new FloorTile(Sprite.floorTileStained02);
	public static Tile floorTileStained03 = new FloorTile(Sprite.floorTileStained03);
	public static Tile floorTileBlood = new FloorTile(Sprite.floorTileBlood);
	public static Tile floorCracked01 = new FloorTile(Sprite.floorTileCracked01);
	public static Tile floorCracked02 = new FloorTile(Sprite.floorTileCracked02);
	public static Tile floorCracked03 = new FloorTile(Sprite.floorTileCracked03);
	public static Tile floorCracked04 = new FloorTile(Sprite.floorTileCracked04);
	public static Tile floorCracked05 = new FloorTile(Sprite.floorTileCracked05);

	public static Tile voidTile = new VoidTile(Sprite.voidTile);
	public static Tile brickTile = new BrickTile(Sprite.brickTile);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean isSolid() {
		return false;
	}

	
}
