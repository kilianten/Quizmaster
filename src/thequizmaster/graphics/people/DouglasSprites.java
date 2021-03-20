package thequizmaster.graphics.people;

import thequizmaster.Constants;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public abstract class DouglasSprites {
	//PLAYERS
	////Douglas
	//////DouglasStanding
	public static Sprite[] douglasStandingSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 0, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 1, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 3, SpriteSheet.douglasSheet)};
	//////DouglasWalking
	public static Sprite[] douglasWalkingFrontSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 2, SpriteSheet.douglasSheet)};
}
