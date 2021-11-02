package thequizmaster.graphics.people;

import thequizmaster.Constants;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public abstract class KarlSprites {
	//KarlStanding
	public static Sprite[] karlStandingSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 4, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 4, SpriteSheet.karlSheet)};
	//KarlWalking
	public static Sprite[] karlWalkingFrontSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 2, SpriteSheet.karlSheet)};

	public static Sprite[] karlWalkingBackSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 0, SpriteSheet.karlSheet)};

	public static Sprite[] karlWalkingLeftSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 3, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 3, SpriteSheet.karlSheet)};

	public static Sprite[] karlWalkingRightSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 1, SpriteSheet.karlSheet)};

	public static Sprite karlHUDFaceImage = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8, 0, SpriteSheet.karlSheet);


	public static Sprite[] karlWireTrapDeathSprites = new Sprite [] {
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 6, SpriteSheet.karlSheet)};

	public static Sprite[] karlChainGameWaiting = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 10, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 11, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 13, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 14, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 15, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 16, 5, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 17, 5, SpriteSheet.karlSheet)};

	public static Sprite karlWireTrapCorpse = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 5, SpriteSheet.karlSheet);

	public static Sprite[] karlChainGamePull = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 10, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 11, 0, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12, 0, SpriteSheet.karlSheet)};

	public static Sprite[] karlChainGameDeath = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9, 6, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 10, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 11, 7, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12, 7, SpriteSheet.karlSheet)};


	public static Sprite[] karlPoisonDeath = new Sprite [] {
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 10, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 11, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 13, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 14, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 15, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 16, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 17, 1, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 10, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 13, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 14, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 15, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 16, 2, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 17, 2, SpriteSheet.karlSheet)};

	public static Sprite[] karlChainedSawChallenge = new Sprite [] {
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 10, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 11, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 13, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 14, 8, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 15, 8, SpriteSheet.karlSheet)};

	public static Sprite[] karlDeathSawChallenge = new Sprite [] {
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 0,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 5,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 6,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 7,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 8,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 9,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 10,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 11,  9, SpriteSheet.karlSheet),
			new Sprite(Constants.DEFAULT_ENTITY_SIZE, 12,  9, SpriteSheet.karlSheet),
			new Sprite(96, 0, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 1, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 2, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 3, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 4, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 5, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 6, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 7, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 8, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 9, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 10, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 11, 0, SpriteSheet.karlSheet96),
			new Sprite(96, 12, 0, SpriteSheet.karlSheet96)
	};









}

