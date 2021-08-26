package thequizmaster.entity.mob;


import thequizmaster.Constants;
import thequizmaster.Game;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.Hitbox;
import thequizmaster.objects.items.Item;

import java.util.Random;

public class Player extends Mob {

	Random random = new Random();

	private Keyboard input;
	private boolean walking = false;
	private boolean animating = false;
	public String fname;
	protected double speed = 2;

	public int poisonLevel = 99;
	public int poisonCounter = 0;
	public int poisonRate = 180 + random.nextInt(50);

	private int currentAnimIndex = 0;
	private long lastUpdate = 0;
	private long currentAnimUpdateTime = 100;
	public boolean dying = false;

	public Hitbox interactionBox;
	
	private String bio;
	private String bestCategory;
	public int playerSelection = 0;

	public boolean isInteracting = false;
	public boolean currentPlayer = false;

	private Sprite[] currentAnim;
	protected Sprite[] standingSprites;
	protected Sprite[] walkingFowardAnim;
	protected Sprite[] walkingBackAnim;
	protected Sprite[] walkingLeftAnim;
	protected Sprite[] walkingRightAnim;
	public Sprite[] wireTrapDeathAnim;
	public Sprite wireTrapCorpse;
	public Sprite HUDImage;
	public Item[] inventory;
	
	public Player(Keyboard input) {
		this.input = input;
		hitbox = new Hitbox(16, 12, -4, 10);
		interactionBox = new Hitbox(20, 20, 0, 11);
		inventory = new Item[9];
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		hitbox = new Hitbox(x, y, 20, 12);
		interactionBox = new Hitbox(2, 2, -2, 10);
		this.input = input;
	}

	public void update() {
		int xa = 0, ya = 0;

		isInteracting = input.interacting;

		hitbox.updateHitbox(x, y);
		interactionBox.updateHitbox(x, y, dir);

		if(currentPlayer){
			if(input.selectionChanged){
				playerSelection = input.playerSelection;
				input.selectionChanged = false;
			}
		}

		if (input.up)
			ya-= speed;
		if (input.down)
			ya+= speed;
		if (input.left)
			xa-= speed;
		if (input.right)
			xa+= speed;
		if (input.useItem){
			if(inventory[playerSelection] != null){
				inventory[playerSelection].use(this);
				inventory[playerSelection] = null;
			}
			input.useItem = false;
		}
		
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

		poisonPlayer();
	}

	private void poisonPlayer(){
		if(poisonCounter >= poisonRate){
			if(poisonLevel >= 1){
				poisonLevel--;
			}
			poisonCounter = 0;
		} else{
			poisonCounter++;
		}
	}

	private void setWalkingAnim() {
		if(dir == 0) {
			currentAnim = walkingBackAnim;
		}
		else if(dir == 1) {
			currentAnim = walkingRightAnim;
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

	public void giveItem(Item item){
		inventory[playerSelection] = item;
	}

	public void renderItems(Screen screen) {
		for(int i = 0; i < inventory.length; i++){
			if(inventory[i] != null){
				inventory[i].renderHUDIcon(screen, i);
			}
		}
	}

	public void increasePoisonLevel(int increase) {
		poisonLevel += increase;
		if(poisonLevel > 99){
			poisonLevel = 99;
		}
	}
}
