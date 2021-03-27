package thequizmaster.entity.mob;


import thequizmaster.Game;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.Hitbox;

public class Player extends Mob {

	private Keyboard input;
	private boolean walking = false;
	private boolean animating = false;
	public String fname;
	protected double speed = 2;

	private int currentAnimIndex = 0;
	private long lastUpdate = 0;
	private long currentAnimUpdateTime = 100;
	public boolean dying = false;
	
	private String bio;
	private String bestCategory;

	private Sprite[] currentAnim;
	protected Sprite[] standingSprites;
	protected Sprite[] walkingFowardAnim;
	protected Sprite[] walkingBackAnim;
	protected Sprite[] walkingLeftAnim;
	public Sprite[] wireTrapDeathAnim;

	public Player(Keyboard input) {
		this.input = input;
		hitbox = new Hitbox(16, 12, -4, 10);
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		hitbox = new Hitbox(x, y, 20, 12);
		this.input = input;
	}

	public void update() {
		int xa = 0, ya = 0;
		
		hitbox.updateHitbox(x, y);

		if (input.up)
			ya-= speed;
		if (input.down)
			ya+= speed;
		if (input.left)
			xa-= speed;
		if (input.right)
			xa+= speed;
		
		if(animating) {
			if(System.currentTimeMillis() - lastUpdate > currentAnimUpdateTime) {
				currentAnimIndex++;
				currentAnimIndex %= currentAnim.length;
				sprite = currentAnim[currentAnimIndex];
				lastUpdate = System.currentTimeMillis();
			}
		}

		if (xa != 0 && canMove || ya != 0 && canMove) {
			move(xa, ya);
			walking = true;
			setWalkingAnim();
			if (animating == false) {
				startAnim();
			}
		} else {
			walking = false;
			animating = false;
		}
	}

	private void setWalkingAnim() {
		if(dir == 0) {
			currentAnim = walkingBackAnim;
		}
		else if(dir == 3) {
			currentAnim = walkingLeftAnim;
		}
		else {
			currentAnim = walkingFowardAnim;
		}
	}

	private void startAnim() {
		animating = true;
		currentAnimIndex = 0;
		lastUpdate = System.currentTimeMillis();
	}

	public void render(Screen screen) {
		int xx = x - 32;
		int yy = y - 32;
		if (!walking && !dying) {
			sprite = standingSprites[dir];
		}
		screen.renderPlayer(xx, yy, sprite);
	}

	public void resetSprite() {
		sprite = standingSprites[2];
	}

}
