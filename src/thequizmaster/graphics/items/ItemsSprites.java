package thequizmaster.graphics.items;

import thequizmaster.Constants;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public abstract class ItemsSprites {

    public static Sprite smallSyringe = new Sprite(16, 0, 0, SpriteSheet.itemsSheet);
    public static Sprite largeSyringe = new Sprite(16, 1, 0, SpriteSheet.itemsSheet);
    public static Sprite mysterySyringe = new Sprite(16, 2, 0, SpriteSheet.itemsSheet);
    public static Sprite poisonSyringe = new Sprite(16, 3, 0, SpriteSheet.itemsSheet);
    public static Sprite wirecutters = new Sprite(16, 4, 0, SpriteSheet.itemsSheet);
    public static Sprite[] bookSprites = new Sprite [] {
            new Sprite(16, 5, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 6, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 7, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 8, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 9, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 10, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 11, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 12, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 13, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 14, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 15, 0, SpriteSheet.itemsSheet),
            new Sprite(16, 16, 0, SpriteSheet.itemsSheet)};
}
