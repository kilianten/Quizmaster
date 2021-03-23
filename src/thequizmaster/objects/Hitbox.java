package thequizmaster.objects;

public class Hitbox {

	public int x;
	public int y;
	public int height;
	public int width;
	
	public Hitbox(int x, int y, int height, int width) {
		System.out.println("HITBOX CREATED AT, X: " + x + " Y: " + y + " WIDTH: " + width + " HEIGHT: " + height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
}
