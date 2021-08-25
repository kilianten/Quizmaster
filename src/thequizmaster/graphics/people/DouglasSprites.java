package thequizmaster.graphics.people;

import thequizmaster.Constants;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public abstract class DouglasSprites {
	//DouglasStanding
	public static Sprite[] douglasStandingSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 0, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 1, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 3, SpriteSheet.douglasSheet)};
	//DouglasWalkingFront
	public static Sprite[] douglasWalkingFrontSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 2, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 2, SpriteSheet.douglasSheet)};
	
	public static Sprite[] douglasWalkingBackSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 0, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 0, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 0, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 0, SpriteSheet.douglasSheet)};
	
	public static Sprite[] douglasWalkingLeftSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 3, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 3, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 3, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 3, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 3, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 3, SpriteSheet.douglasSheet)};
	
	public static Sprite[] douglasWalkingRightSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 1, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 1, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 1, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 1, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 1, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 1, SpriteSheet.douglasSheet)};
	
	public static Sprite[] douglasWireTrapDeathSprites = new Sprite [] {
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 4, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 4, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 4, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 4, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 4, SpriteSheet.douglasSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 4, SpriteSheet.douglasSheet)};
	
	public static Sprite douglasWireTrapCorpse = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 4, SpriteSheet.douglasSheet);
	public static Sprite douglasHUDFaceImage = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 0, SpriteSheet.douglasSheet);

}
