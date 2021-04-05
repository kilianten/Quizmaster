package thequizmaster.objects;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class TripWire extends CollidableObject {
	
	private boolean tripped = false;
	private Sprite sprite = Sprite.tripWire;
	
	public TripWire(int x, int y) {
		this.y = y;
		this.x = x;
		hitbox = new Hitbox(x, y, 2, 64, 15, 2);
	}

	public void render(Screen screen) {
		screen.renderObject(x, y, sprite);
	}
	
	public void update() {
		
	}
	
	public boolean checkCollision(int playerX, int playerY, int playerDir){
		int xOffset = 0;
		if(playerDir == 3) {
			xOffset += 16;
		}
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < sprite.YSIZE; j++) {
				if(playerX == i + x + xOffset && playerY == j + y) {
					tripped = true;
					return true;
				}
			}
		}
		return false;
	}
	
	
}
