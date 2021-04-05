package thequizmaster.objects;

public class CollidableObject extends GameObject {

	public Hitbox hitbox;

	public boolean checkCollision(int x, int y, int dir) {
		return false;
	}
	
}
