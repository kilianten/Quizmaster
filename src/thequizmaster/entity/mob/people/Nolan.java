package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.people.DouglasSprites;
import thequizmaster.graphics.people.NolanSprites;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;

public class Nolan extends Player {
	
	public Nolan(Keyboard input, MainGame game) {
		super(input, game);
		setAnims();
		fname = "Fr.";
		x = 74 * 32;
		y = 74 * 32;
	}
	
	public void setAnims() {
		standingSprites = NolanSprites.nolanStandingSprites;
		walkingFowardAnim = NolanSprites.nolanWalkingFrontSprites;
		walkingBackAnim = NolanSprites.nolanWalkingBackSprites;
		walkingLeftAnim = NolanSprites.nolanWalkingLeftSprites;
		walkingRightAnim = NolanSprites.nolanWalkingRightSprites;
		wireTrapDeathAnim = DouglasSprites.douglasWireTrapDeathSprites;

		sprite = standingSprites[0];
		HUDImage = NolanSprites.nolanHUDFaceImage;
	}
	
	


}