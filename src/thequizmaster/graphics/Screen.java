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

    public void render(){
        for(int y = 0; y < height; y++){
            int yy = y;
            if (yy < 0 || yy >= height) break;
            for(int x = 0; x < width; x++){
                int xx = x;
                if (xx < 0 || xx >= width) break;
                int tileIndex = (xx >> 5) + (yy >> 5) * 64;
                pixels[x + y * width] = tiles[tileIndex];
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
