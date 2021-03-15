package thequizmaster.graphics;

import java.util.Random;

import thequizmaster.level.tile.Tile;

public class Screen {

    private int width, height;
    private int[] pixels;
    private int[] tiles = new int[64 * 64];
    private Random random = new Random();
    
    private int xOffset, yOffset;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < 64*64; i++){
            tiles[i] = random.nextInt(0xffffff);
        }
    }



    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0x000000;
        }
    }

    public int[] getPixels(){
        return pixels;
    }
    
    public void renderTile(int xp, int yp, Tile tile) {
    	xp -= xOffset;
    	yp -= yOffset;
    	for(int y = 0; y < tile.getSprite().getSIZE(); y++) {
    		int ya = yp + y;
        	for(int x = 0; x < tile.getSprite().getSIZE(); x++) {
        		int xa = xp + x;
        		if(xa < 0 || xa >= width || ya < 0 || ya >= height) break;
        		pixels[xa + ya * width] = tile.getSprite().getPixels()[x + y * tile.getSprite().getSIZE()];
        	}
    	}
    }
   
    public void setOffset(int xOffset, int yOffset) {
    	this.xOffset = xOffset;
    	this.yOffset = yOffset;
    }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

    
}
