package thequizmaster.graphics.items;

import thequizmaster.Constants;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public abstract class TrapSprites {

    public static Sprite searchBoxSprite = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 0, SpriteSheet.trapsSheet);

    public static Sprite[] chainGameSawSprites = new Sprite [] {new Sprite(Constants.DEFAULT_ENTITY_SIZE, 1, 1, SpriteSheet.trapsSheet),
            new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 1, SpriteSheet.trapsSheet),
            new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 1, SpriteSheet.trapsSheet),
            new Sprite(Constants.DEFAULT_ENTITY_SIZE, 4, 1, SpriteSheet.trapsSheet)};

    public static Sprite chainGameOffLight = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 10, 2, SpriteSheet.trapsSheet);
    public static Sprite chainGameOnLight = new Sprite(Constants.DEFAULT_SPRITE_SIZE, 11, 2, SpriteSheet.trapsSheet);

    public static Sprite startButtonSprite = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 2, 0, SpriteSheet.trapsSheet);
    public static Sprite tvSprite = new Sprite(Constants.DEFAULT_ENTITY_SIZE, 3, 0, SpriteSheet.trapsSheet);
    public static Sprite[] tvNumbers = new Sprite [] {
            new Sprite(Constants.DEFAULT_SPRITE_SIZE, 10, 0, SpriteSheet.trapsSheet),
            new Sprite(Constants.DEFAULT_SPRITE_SIZE, 11, 0, SpriteSheet.trapsSheet),
            new Sprite(Constants.DEFAULT_SPRITE_SIZE, 10, 1, SpriteSheet.trapsSheet),
            new Sprite(Constants.DEFAULT_SPRITE_SIZE, 11, 1, SpriteSheet.trapsSheet),
            new Sprite(Constants.DEFAULT_SPRITE_SIZE, 12, 0, SpriteSheet.trapsSheet)};


}

