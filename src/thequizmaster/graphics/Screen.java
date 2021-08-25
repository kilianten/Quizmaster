package thequizmaster.graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import thequizmaster.Constants;
import thequizmaster.level.tile.Tile;
import thequizmaster.objects.Hitbox;

public class Screen {

    public int width;
	public int height;
    private int[] pixels;
    private int[] HUDpixels;
    private int[] tiles = new int[64 * 64];
    private Random random = new Random();
    
    private int xOffset, yOffset;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        HUDpixels = new int[width * height];

        for (int i = 0; i < 64*64; i++){
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0x000000;
        }
        for(int i = 0; i < pixels.length; i++){
            HUDpixels[i] = 0x000000;
        }
    }

    public int[] getPixels(){
        return pixels;
    }
    

    public void renderPlayer(int xp, int yp, Sprite sprite) {
    	xp -= xOffset;
    	yp -= yOffset;
    	
    	for(int y = 0; y < 64; y++) {
    		int ya = y + yp;
    		for(int x = 0; x < 64; x++) {
    			int xa = x + xp;
    			if(xa < -64 || xa >= width || ya < 0 || ya >= height) break;
    			if (xa < 0) xa = 0;
    			int col = sprite.pixels[x + y * 64];
    			if(col != 0xfff000ca) pixels[xa + ya * width] = col;
    		}
    	}
    }
    
    public void renderLight(int xp, int yp) {
    	xp -= xOffset;
    	yp -= yOffset;
    	
    	
    }
    
    public void renderTile(int xp, int yp, Tile tile) {
    	xp -= xOffset;
    	yp -= yOffset;
    	for(int y = 0; y < tile.sprite.YSIZE; y++) {
    		int ya = yp + y;
        	for(int x = 0; x < tile.sprite.SIZE; x++) {
        		int xa = xp + x;
        		if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
        		if(xa < 0) xa = 0;
        		pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
        	}
    	}
    }
    
    public void renderObject(int xp, int yp, Sprite sprite) {
    	xp -= xOffset;
    	yp -= yOffset;
    	for(int y = 0; y < sprite.YSIZE; y++) {
    		int ya = yp + y;
        	for(int x = 0; x < sprite.SIZE; x++) {
        		int xa = xp + x;
        		if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
        		if(xa < 0) xa = 0;
        		int col = sprite.pixels[x + y * sprite.SIZE];
    			if(col != 0xfff000ca) pixels[xa + ya * width] = col;
        	}
    	}
    }

    public void renderFixedObject(int xp, int yp, Sprite sprite) {
    	for(int y = 0; y < sprite.YSIZE; y++) {
    		int ya = yp + y;
        	for(int x = 0; x < sprite.SIZE; x++) {
        		int xa = xp + x;
        		if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
        		if(xa < 0) xa = 0;
        		int col = sprite.pixels[x + y * sprite.SIZE];
    			if(col != 0xfff000ca) HUDpixels[xa + ya * width] = col;
        	}
    	}
    }

	public void drawHUDRect(int xp, int yp, int rectWidth, int rectHeight, int colour) {
		for(int y = 0; y < rectHeight; y++) {
			int ya = yp + y;
			for(int x = 0; x < rectWidth; x++) {
				int xa = xp + x;
				HUDpixels[xa + ya * width] = colour;
			}
		}
	}
    
    public void renderHitbox(Hitbox hitbox, int color) {
    	int xp = hitbox.getX() - xOffset;
    	int yp = hitbox.getY() - yOffset;

    	for(int i = 0; i < hitbox.height; i++) {
    		int ya = yp + i;
        	for(int j = 0; j < hitbox.width; j++) {
        		int xa = xp + j;
        		if(xa < -hitbox.height || xa >= width || ya < 0 || ya >= height) break;
        		if(xa < 0) xa = 0;
    			pixels[xa + ya * width] = color;
        	}
    	}
    }
    
	public void renderLight(Graphics2D g, int xp, int yp) {
		xp -= xOffset;
    	yp -= yOffset;
    	
    	xp *= 4;
    	yp *= 4;
    	
		Point2D center = new Point2D.Float(xp, yp);
		float[] distance = {0.0f, 0.8f};
		Color[] colors = {new Color(0.0f, 0.0f, 0.0f, 0.0f), Color.BLACK};
		RadialGradientPaint p = new RadialGradientPaint(center, Constants.LIGHT_RADIUS, distance, colors);
		g.setPaint(p);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .95f));
		g.fillRect(0, 0, Constants.screenWidth * 4, Constants.screenHeight * 4);
	}

    public void setOffset(int xOffset, int yOffset) {
    	this.xOffset = xOffset;
    	this.yOffset = yOffset;
    }

	public int[] getHUDPixels() {
		return HUDpixels;
	}

    
}
