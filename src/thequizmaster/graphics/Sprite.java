package thequizmaster.graphics;

import thequizmaster.Constants;

public class Sprite {

    private final int SIZE;
    private int x, y;
    private int[] pixels;
    private SpriteSheet sheet;

    public static Sprite floorTile = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 0, 0, SpriteSheet.tileSheet);

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
                pixels[x + y * SIZE] = sheet.getPixels()[(x + this.x) + (y + this.y) * sheet.getSIZE()];
            }
        }
    }

	public int[] getPixels() {
		return pixels;
	}

	public int getSIZE() {
		return SIZE;
	}

    
}
