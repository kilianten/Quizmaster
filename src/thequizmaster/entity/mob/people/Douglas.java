package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Mob;
import thequizmaster.graphics.Sprite;

public class Douglas extends Mob {
	
	
	
	public Sprite[] getStandingSpriteAnimation() {
		return Sprite.douglasStandingSprites;
	}
	
	public Sprite[] getWalkingFowardAnimation() {
		return Sprite.douglasWalkingFrontSprites;
	}
	
}
