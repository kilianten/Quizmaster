package thequizmaster.objects;

import thequizmaster.entity.mob.Mob;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class GameObject implements Comparable<GameObject>{
	
	public int x;
	public int y;
	public int drawYOffset = 0;
	protected Sprite sprite;

	
	public void render(Screen screen) {
		screen.renderObject(x, y, sprite);
	}

	public void update() {
		
	}

	public int getDrawY(){
		return this.y + sprite.YSIZE + drawYOffset;
	}

	@Override
	public int compareTo(GameObject o) {
		return Integer.compare(getDrawY(), o.getDrawY());
	}
}
