package thequizmaster.objects;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class Corpse extends GameObject {
	
	public Corpse(int x, int y, Sprite sprite) {
		this.y = y;
		this.x = x;
		this.sprite = sprite;
	}

	public Corpse(int x, int y, Sprite sprite, int drawYOffset) {
		this.y = y;
		this.x = x;
		this.sprite = sprite;
		this.drawYOffset = drawYOffset;
	}
	
	public void render(Screen screen) {
		screen.renderObject(x - 32, y - 32, sprite);
	}

	public int getDrawY(){
		return this.y + (sprite.YSIZE);
	}


	public void update() {
		
	}

}
