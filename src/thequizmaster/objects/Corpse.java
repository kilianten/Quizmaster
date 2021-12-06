package thequizmaster.objects;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class Corpse extends GameObject {
	
	public Corpse(int x, int y, Sprite sprite) {
		this.y = y;
		this.x = x;
		this.sprite = sprite;
		drawYOffset = -sprite.SIZE/4;
	}

	public Corpse(int x, int y, Sprite sprite, int drawYOffset) {
		this.y = y;
		this.x = x;
		this.sprite = sprite;
		this.drawYOffset = drawYOffset;
	}
	
	public void render(Screen screen) {
		screen.renderObject(x - sprite.SIZE/2, y - sprite.SIZE/2, sprite);
	}

	public int getDrawY(){
		System.out.println(drawYOffset);
		return this.y + sprite.YSIZE + drawYOffset;
	}


	public void update() {
		
	}

}
