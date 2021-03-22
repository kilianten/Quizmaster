package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.graphics.people.DouglasSprites;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;

public class Douglas extends Player {
	
	public Douglas(Keyboard input, Level level) {
		super(input);
		setAnims();
		fname = "Douglas";
		this.level = level;
	}
	
	public Douglas(int x, int y, Keyboard input) {
		super(x, y, input);
		setAnims();
		fname = "Douglas";
	}
	
	public void setAnims() {
		standingSprites = DouglasSprites.douglasStandingSprites;
		walkingFowardAnim = DouglasSprites.douglasWalkingFrontSprites;
		walkingBackAnim = DouglasSprites.douglasWalkingBackSprites;
		walkingLeftAnim = DouglasSprites.douglasWalkingLeftSprites;
		sprite = standingSprites[0];
	}
	


}
