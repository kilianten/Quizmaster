package thequizmaster.entity.mob;

import thequizmaster.entity.Entity;
import thequizmaster.graphics.Sprite;

public class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
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
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public boolean isColliding() {
		return false;
	}
	
}
