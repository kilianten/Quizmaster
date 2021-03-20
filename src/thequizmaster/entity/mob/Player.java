package thequizmaster.entity.mob;

import thequizmaster.entity.mob.people.Douglas;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private boolean walking = false;
	private boolean animating = false;

	private int currentAnimIndex = 0;
	private long lastUpdate = 0;
	private long currentAnimUpdateTime = 100;

	private Sprite[] currentAnim;
	private Sprite[] standingSprites;
	private Sprite[] walkingFowardAnim;

	public Player(Keyboard input) {
		this.input = input;
		setPlayer(new Douglas());
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		int xa = 0, ya = 0;

		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		
		if(animating) {
			if(System.currentTimeMillis() - lastUpdate > currentAnimUpdateTime) {
				currentAnimIndex++;
				currentAnimIndex %= currentAnim.length;
				sprite = currentAnim[currentAnimIndex];
				lastUpdate = System.currentTimeMillis();
			}
		}

		if (xa != 0 || ya != 0) {
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
		currentAnim = walkingFowardAnim;
	}

	private void startAnim() {
		animating = true;
		currentAnimIndex = 0;
		lastUpdate = System.currentTimeMillis();
	}

	public void render(Screen screen) {
		int xx = x - 32;
		int yy = y - 32;
		if (!walking) {
			sprite = standingSprites[dir];
		}
		screen.renderPlayer(xx, yy, sprite);
	}

	public void setPlayer(Mob person) {
		standingSprites = person.getStandingSpriteAnimation();
		walkingFowardAnim = person.getWalkingFowardAnimation();
	}

}
