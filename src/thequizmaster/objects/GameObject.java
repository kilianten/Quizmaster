package thequizmaster.objects;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class GameObject {
	
	protected int x;
	public int y;
	protected Sprite sprite;
	
	public void render(Screen screen) {
		screen.renderObject(x, y, sprite);
	}

	public void update() {
		
	}
	

	
}
