package thequizmaster.graphics;

import java.util.Random;

public class Screen {

    private int width, height;
    private int[] pixels;
    private int[] tiles = new int[64 * 64];
    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < 64*64; i++){
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void render(int xOffset, int yOffset){
        for(int y = 0; y < height; y++){
        	int yp = y + yOffset;
        	if (yp < 0 || yp >= height) continue;
            for(int x = 0; x < width; x++){
            	int xp = x + xOffset;
            	if(xp < 0 || xp >= width) continue;
                pixels[xp + yp * width] = Sprite.floorTile.getPixels()[(x & 31) + (y& 31) * 32];
            }
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
    
    
}
