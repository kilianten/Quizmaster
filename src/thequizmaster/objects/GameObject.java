package thequizmaster.objects;

import thequizmaster.entity.mob.Mob;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class GameObject implements Comparable<GameObject>{
	
	public int x;
	public int y;
	protected Sprite sprite;
	protected int drawLevel = 0;
	
	public void render(Screen screen) {
		screen.renderObject(x, y, sprite);
	}

	public void update() {
		
	}

	@Override
	public int compareTo(GameObject o) {
		return Integer.compare(y, o.y);
	}
}
