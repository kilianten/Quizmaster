package thequizmaster.objects;

import thequizmaster.gamestates.MainGame;

public class CollidableObject extends GameObject {

	public Hitbox hitbox;

	public String objectType;
	public boolean canWalkThrough = true;

	public boolean checkCollision(int x, int y, int dir) {
		return false;
	}
	
	public void hasCollided(MainGame game) {
		
	}

	public void isInteractedWith(MainGame mainGame) {
	}
	
}
