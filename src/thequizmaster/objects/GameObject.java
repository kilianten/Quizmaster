package thequizmaster.objects;

import thequizmaster.Constants;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class GameObject {
	
	private int x;
	private int y;
	protected Sprite sprite;
	
	
	public void render(Screen screen) {
	}

	public void update() {
		
	}
	
	public boolean checkCollision(int x, int y, int dir) {
		return false;
	}
	
}
