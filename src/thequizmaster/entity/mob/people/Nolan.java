package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.people.DouglasSprites;
import thequizmaster.graphics.people.NolanSprites;
import thequizmaster.input.Keyboard;

public class Nolan extends Player {
	
	public Nolan(Keyboard input, MainGame game) {
		super(input, game);
		setAnims();
		fname = "Fr.";
		sname = "Nolan";
		x = 74 * 32;
		y = 74 * 32;
		questionKnowledge.put("religion", 4);
		questionKnowledge.put("books", 2);
	}

	public void update(){
		super.update();
		System.out.println(animation);
	}
	
	public void setAnims() {
		standingSprites = NolanSprites.nolanStandingSprites;
		walkingFowardAnim = NolanSprites.nolanWalkingFrontSprites;
		walkingBackAnim = NolanSprites.nolanWalkingBackSprites;
		walkingLeftAnim = NolanSprites.nolanWalkingLeftSprites;
		walkingRightAnim = NolanSprites.nolanWalkingRightSprites;
		wireTrapDeathAnim = DouglasSprites.douglasWireTrapDeathSprites;

		chainGameWaiting = NolanSprites.nolanChainGameWaiting;
		chainGamePull = NolanSprites.nolanChainGamePull;
		chainGameDeath = NolanSprites.nolanChainGameDeath;

		idleAnims = NolanSprites.nolanIdleSprites;

		sprite = standingSprites[2];
		HUDImage = NolanSprites.nolanHUDFaceImage;
	}
	
	


}