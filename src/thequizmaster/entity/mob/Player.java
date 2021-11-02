package thequizmaster.entity.mob;


import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Animation;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.Corpse;
import thequizmaster.objects.Hitbox;
import thequizmaster.objects.items.ChargesItem;
import thequizmaster.objects.items.Item;

import java.util.*;

public class Player extends Mob {

    public Sprite chainGameDeathCorpse;
    Random random = new Random();

	public Keyboard input;
	public boolean walking = false;
	private boolean animating = false;
	public String fname;
	public String sname;
	protected double speed = 2;

	public int poisonLevel = 99;
	public int poisonCounter = 0;
	public int poisonRate = 180 + random.nextInt(50);

	private int currentAnimIndex = 0;
	private long lastUpdate = 0;
	private long currentAnimUpdateTime = 100;
	public boolean dying = false;
	public boolean isDead = false;

	public Hitbox interactionBox;
	
	private String bio;
	public int playerSelection = 0;

	public boolean currentPlayer = false;

	private Sprite[] currentAnim;
	protected Sprite[] standingSprites;
	protected Sprite[] walkingFowardAnim;
	protected Sprite[] walkingBackAnim;
	protected Sprite[] walkingLeftAnim;
	protected Sprite[] walkingRightAnim;

	protected Sprite[] poisonAnim;
	public Sprite[][] idleAnims;

	public Sprite[] chainGameWaiting;
	public Sprite[] chainGamePull;
	public Sprite[] chainGameDeath;

	public Sprite[] wireTrapDeathAnim;
	public Sprite wireTrapCorpse;
	public Sprite HUDImage;
	public Item[] inventory;
	public Sprite deathImage = null;

	public Animation animation = null;

	public Map<String, Integer> questionKnowledge;

	public Player(Keyboard input, MainGame game) {
		this.input = input;
		hitbox = new Hitbox(16, 12, -4, 10);
		interactionBox = new Hitbox(20, 20, 0, 11);
		inventory = new Item[9];
		this.game = game;
		createQuestionKnowledgeMap();
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		hitbox = new Hitbox(x, y, 20, 12);
		interactionBox = new Hitbox(2, 2, -2, 10);
		this.input = input;
	}

	public void update() {
		if(currentPlayer && !dying){
			checkIfSelectingItem();
			checkWalkingInput();
			checkUsingItemInput();
			checkDroppingItemInput();
			updateHitboxes();
			updateSelectedItem();
		}
		updateAnimation();
		if(!dying){
			poisonPlayer();
		}
		if(dying && animation == null){
			game.addDrawObject(new Corpse(x, y, poisonAnim[17]));
			killPlayer(poisonAnim[17]);
			if(currentPlayer){
				game.replaceCurrentPlayer();
			}
			isDead = true;
		}


	}

	private void updateSelectedItem() {
		if(inventory[playerSelection] != null){
			inventory[playerSelection].updateSelected(game);
		}
	}

	public void animatePlayer(){
		if(animation != null){
			if(animation.isFinished){
				animation = null;
			} else {
				animation.update();
			}
		}
	}

	public void killPlayer(Sprite sprite){
		isDead = true;
		deathImage = sprite;
		for(int i = 0; i < inventory.length; i++){
			if(inventory[i] != null){
				int xOffset = random.nextInt(32);
				int yOffset = random.nextInt(4);
				game.createItem(x - 32 + xOffset, y + 40 + yOffset, inventory[i].name);
			}
		}
	}

	public void movePlayer(int x, int y){
		this.x = x;
		this.y = y;
		updateHitboxes();
	}

	private void updateHitboxes(){
		hitbox.updateHitbox(x, y);
		interactionBox.updateHitbox(x, y, dir);
	}

	private void checkIfSelectingItem(){
		if(currentPlayer){
			if(input.selectionChanged){
				playerSelection = input.playerSelection;
				input.selectionChanged = false;
			}
		}
	}

	private void updateAnimation(){
		if(animation != null){
			if(animation.isFinished){
				animation = null;
			} else{
				animation.update();
			}
		}
		if(animating) {
			if(System.currentTimeMillis() - lastUpdate > currentAnimUpdateTime) {
				currentAnimIndex++;
				currentAnimIndex %= currentAnim.length;
				sprite = currentAnim[currentAnimIndex];
				lastUpdate = System.currentTimeMillis();
			}
		}
	}

	private void checkDroppingItemInput(){
		if(input.droppingItem){
			if(inventory[playerSelection] != null){
				game.createItem(x, y, inventory[playerSelection].name);
				inventory[playerSelection] = null;
			}
			input.droppingItem = false;
		}
	}

	private void checkUsingItemInput(){
		if (input.useItem){
			if(inventory[playerSelection] != null){
				boolean itemUsed = inventory[playerSelection].use(this, game);
				if(inventory[playerSelection] instanceof ChargesItem && itemUsed){
					((ChargesItem) inventory[playerSelection]).numberOfChargesRemaining--;
					if(((ChargesItem) inventory[playerSelection]).numberOfChargesRemaining == 0){
						inventory[playerSelection] = null;
					}
				} else {
					if(itemUsed){
						inventory[playerSelection] = null;
					}
				}
			}
			input.useItem = false;
		}
	}

	private void checkWalkingInput(){
		int xa = 0, ya = 0;
		if (input.up)
			ya-= speed;
		if (input.down)
			ya+= speed;
		if (input.left)
			xa-= speed;
		if (input.right)
			xa+= speed;

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

	private void poisonPlayer(){
		if(poisonLevel <= 0){
			dying = true;
			animation = new Animation(.8, poisonAnim, this, 3, false);
		} else {
			if(poisonCounter >= poisonRate){
				if(poisonLevel >= 1){
					poisonLevel--;
				}
				poisonCounter = 0;
			} else{
				poisonCounter++;
			}
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
		if (!walking && !dying && animation == null) {
			sprite = standingSprites[dir];
		}
		screen.renderPlayer(xx, yy, sprite);
	}

	public void resetSprite() {
		sprite = standingSprites[2];
	}

	public Item giveItem(Item item){
		Item previousItem = inventory[playerSelection];

		inventory[playerSelection] = item;
		if (previousItem != null){
			previousItem.updatePosition(x - 5, y + 30);
		}

		return previousItem;
	}

	public void renderItems(Screen screen) {
		for(int i = 0; i < inventory.length; i++){
			if(inventory[i] != null){
				inventory[i].renderHUDIcon(screen, i);
				if(inventory[i] instanceof ChargesItem){
					((ChargesItem) inventory[i]).renderCharges(screen, i);
				}
			}
		}
	}

	public void increasePoisonLevel(int increase) {
		poisonLevel +=  increase;
		if(poisonLevel > 99){
			poisonLevel = 99;
		}
	}

	public void decreasePoisonLevel(int decrease) {
		poisonLevel -=  decrease;
		if(poisonLevel < 0){
			poisonLevel = 0;
		}
	}

	public Sprite getPlayerMainSprite(){
		if(isDead){
			return deathImage;
		}
		return standingSprites[2];
	}

	public void createQuestionKnowledgeMap(){
		questionKnowledge = new TreeMap<>();
		questionKnowledge.put("geography", 0);
		questionKnowledge.put("politics", 0);
		questionKnowledge.put("quotes", 0);
		questionKnowledge.put("history", 0);
		questionKnowledge.put("literature", 0);
		questionKnowledge.put("sports", 0);
		questionKnowledge.put("film", 0);
		questionKnowledge.put("music", 0);
		questionKnowledge.put("language", 0);
		questionKnowledge.put("religion", 0);
		questionKnowledge.put("science", 0);
	}

	public int getKnowledge(ArrayList<String> categories) {
		int maxKnowledge = 0;
		for(String category: categories){
			if(questionKnowledge.containsKey(category)){
				if(questionKnowledge.get(category) > maxKnowledge){
					maxKnowledge = questionKnowledge.get(category);
				}
			} else {
				System.out.println(category + " not included in map");
			}
		}
		return maxKnowledge * 10;
	}

	public boolean increaseKnowledge(String category) {
		if(questionKnowledge.get(category) >= 4){
			return false;
		} else {
			questionKnowledge.put(category, questionKnowledge.get(category) + 1);
			return true;
		}
	}
}
