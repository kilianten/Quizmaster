package thequizmaster.entity.mob;

import thequizmaster.Constants;
import thequizmaster.entity.Entity;
import thequizmaster.graphics.Sprite;

public class Mob extends Entity {

	public Sprite sprite;
	protected int dir = 2;
	protected boolean moving = false;
	protected Sprite[] currentAnimation;
	
	public void move(int xa, int ya) {
		if(xa != 0 && ya != 0) { //separate if moving on both axis
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		if(!isColliding(xa, ya)) {
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
	
	public boolean isColliding(int xa, int ya) {
		boolean solid = false;
		for(int corner = 0; corner < 4; corner++) {
			int xt = ((x + xa) + corner % 2 * 19 - 10) / Constants.DEFAULT_SPRITE_SIZE;
			int yt = ((y + ya) + corner / 2 * 21 + 10) / Constants.DEFAULT_SPRITE_SIZE;
			if(level.getTile(xt, yt).isSolid()) {
				solid = true;
			}
		}
		return solid;
	}

	public Sprite[] getStandingSpriteAnimation() {
		return null;
	}
	
	public Sprite[] getWalkingFowardAnimation() {
		return null;
	}
}
