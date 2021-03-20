package thequizmaster.entity.mob;

import thequizmaster.entity.Entity;
import thequizmaster.graphics.Sprite;

public class Mob extends Entity {

	public Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected Sprite[] currentAnimation;
	
	public void move(int xa, int ya) {
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		if(!isColliding()) {
			x += xa;
			y += ya;
		}
		
	}
	
	private void setAnimation() {

	}

	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public boolean isColliding() {
		return false;
	}

	public Sprite[] getStandingSpriteAnimation() {
		return null;
	}
	
	public Sprite[] getWalkingFowardAnimation() {
		return null;
	}
}
