package thequizmaster.objects;

public class Hitbox {

	private int x;
	private int y;
	public int height;
	public int width;
	private int xOffset;
	private int yOffset;
	private Object gameObject;
	
	public Hitbox(int x, int y, int width, int height, int xOffset, int yOffset) {
		this.x = x;
		this.y = y;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.width = width;
		this.height = height;
		this.gameObject = gameObject;
	}

	public Hitbox(int width, int height, int xOffset, int yOffset) {
		x = 0;
		y = 0;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.width = width;
		this.height = height;
	}

	public void updateHitbox(int newX, int newY) {
		x = newX + xOffset;
		y = newY + yOffset;
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
