package thequizmaster.objects;

import thequizmaster.graphics.Sprite;

public class Hitbox {

	public int x;
	public int y;
	public int height;
	public int width;
	private int xOffset;
	private int yOffset;
	
	public Hitbox(int x, int y, int width, int height, int xOffset, int yOffset) {
		this.x = x;
		this.y = y;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.width = width;
		this.height = height;
	}

	public Hitbox(int width, int height, int xOffset, int yOffset) {
		x = 0;
		y = 0;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.width = width;
		this.height = height;
	}

    public Hitbox(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.xOffset = 0;
		this.yOffset = 0;
		this.width = sprite.SIZE;
		this.height = sprite.SIZE;
    }

    public void updateHitbox(int newX, int newY) {
		x = newX + xOffset;
		y = newY + yOffset;
	}

	public void updateHitbox(int newX, int newY, int dir) {
		x = newX;
		y = newY;
		if(dir == 0){
			y -= 5;
			x -= 10;
		}
		else if(dir == 1){
			x += 10;
			y += 10;
		}
		else if(dir == 2){
			y += 20;
			x -= 10;
		}
		else {
			x -= 28;
			y += 10;
		}
	}
	
	public static boolean isWithinHitbox(Hitbox hitbox, int othery, int otherx) {
		if (otherx >= hitbox.getX() && otherx <= hitbox.getX() + hitbox.width && 
				othery >= hitbox.getY() && othery <= hitbox.getY() + hitbox.height) {
			    return true;
		}
		return false;
	}
	
	public static boolean isColliding(Hitbox firstHitbox, Hitbox secondHitbox) {
    	for(int i = 0; i < secondHitbox.height; i++) {
        	for(int j = 0; j < secondHitbox.width; j++) {
        		if(isWithinHitbox(firstHitbox, i + secondHitbox.getY(), j + secondHitbox.getX())) {
        			return true;
        		}
        	}
    	}
		return false;
	}

	public int getX() {
		return x + xOffset;
	}
	
	public int getY() {
		return y + yOffset;
	}

}
