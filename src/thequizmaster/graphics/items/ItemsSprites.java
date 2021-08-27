package thequizmaster.graphics.items;

import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public abstract class ItemsSprites {

    public static Sprite smallSyringe = new Sprite(16, 0, 0, SpriteSheet.itemsSheet);
    public static Sprite largeSyringe = new Sprite(16, 1, 0, SpriteSheet.itemsSheet);
    public static Sprite mysterySyringe = new Sprite(16, 2, 0, SpriteSheet.itemsSheet);
    public static Sprite poisonSyringe = new Sprite(16, 3, 0, SpriteSheet.itemsSheet);
    public static Sprite wirecutters = new Sprite(16, 4, 0, SpriteSheet.itemsSheet);
}
