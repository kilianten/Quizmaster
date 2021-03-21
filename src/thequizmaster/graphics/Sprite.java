package thequizmaster.graphics;

import thequizmaster.Constants;

public class Sprite {

    public final int SIZE;
    public int x, y;
    public int[] pixels;
    public SpriteSheet sheet;
	public int getPixels;

	//TILES
    public static Sprite floorTile = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 0, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileStained01 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 1, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileStained02 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 2, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileStained03 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 3, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileBlood = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 4, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileCracked01 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 5, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileCracked02 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 6, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileCracked03 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 7, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileCracked04 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 8, 0, SpriteSheet.tileSheet);
    public static Sprite floorTileCracked05 = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 9, 0, SpriteSheet.tileSheet);
    public static Sprite voidTile = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 10, 0, SpriteSheet.tileSheet);

    public static Sprite brickTile = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 1, 1, SpriteSheet.tileSheet);
    public static Sprite brickTileCorner = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 1, 3, SpriteSheet.tileSheet);

    
    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this. y = y * size;
        this.sheet = sheet;
        load();
    }

    public void load(){
        for (int y = 0; y < SIZE; y++){
            for (int x = 0; x < SIZE; x++){
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

    
}
