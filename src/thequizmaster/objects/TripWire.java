package thequizmaster.objects;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class TripWire extends GameObject {
	
	private int x;
	private int y;
	private boolean tripped = false;
	private Sprite sprite = Sprite.tripWire;
	
	public TripWire(int x, int y) {
		this.y = y;
		this.x = x;
	}
	
	public void render(Screen screen) {
		screen.renderObject(x, y, sprite);
	}

	public void update() {
		
	}
	
	
}
