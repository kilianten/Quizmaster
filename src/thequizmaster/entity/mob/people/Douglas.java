package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.graphics.people.DouglasSprites;
import thequizmaster.input.Keyboard;

public class Douglas extends Player {
	
	public Douglas(Keyboard input) {
		super(input);
		standingSprites = DouglasSprites.douglasStandingSprites;
		walkingFowardAnim = DouglasSprites.douglasWalkingFrontSprites;
		sprite = standingSprites[0];
		fname = "Douglas";
	}
	
	public Douglas(int x, int y, Keyboard input) {
		super(x, y, input);
		standingSprites = DouglasSprites.douglasStandingSprites;
		walkingFowardAnim = DouglasSprites.douglasWalkingFrontSprites;
		sprite = standingSprites[0];
		fname = "Douglas";
	}
	


}
