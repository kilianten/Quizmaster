package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.graphics.people.DouglasSprites;
import thequizmaster.graphics.people.NolanSprites;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;

public class Nolan extends Player {
	
	public Nolan(Keyboard input, Level level) {
		super(input);
		setAnims();
		fname = "Fr.";
		x = 74 * 32;
		y = 74 * 32;
		this.level = level;
	}
	
	public Nolan(int x, int y, Keyboard input) {
		super(x, y, input);
		setAnims();
		fname = "Fr.";
	}
	
	public void setAnims() {
		standingSprites = NolanSprites.nolanStandingSprites;
		walkingFowardAnim = NolanSprites.nolanWalkingFrontSprites;
		walkingBackAnim = NolanSprites.nolanWalkingFrontSprites;
		walkingLeftAnim = NolanSprites.nolanWalkingFrontSprites;
		wireTrapDeathAnim = DouglasSprites.douglasWireTrapDeathSprites;

		sprite = standingSprites[0];
	}
	
	


}