package thequizmaster.graphics.people;

import thequizmaster.Constants;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public abstract class KarlSprites {
	//karlStanding
	public static Sprite[] karlStandingSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 3, SpriteSheet.karlSheet)};
	//karlWalkingFront
	public static Sprite[] karlWalkingFrontSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 2, SpriteSheet.karlSheet)};
	
	public static Sprite[] karlWalkingBackSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 0, SpriteSheet.karlSheet)};
	
	public static Sprite[] karlWalkingLeftSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 3, SpriteSheet.karlSheet)};
	
	public static Sprite[] karlWalkingRightSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 1, SpriteSheet.karlSheet)};
	
	public static Sprite[] karlWireTrapDeathSprites = new Sprite [] {
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 4, SpriteSheet.karlSheet)};
	
	public static Sprite karlWireTrapCorpse = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 4, SpriteSheet.karlSheet);
	public static Sprite karlHUDFaceImage = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 0, SpriteSheet.karlSheet);

}
