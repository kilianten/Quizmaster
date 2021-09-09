package thequizmaster.objects.items;

import thequizmaster.Constants;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public abstract class ChargesItem extends Item {

    public int numberOfCharges;
    public int numberOfChargesRemaining;

    public ChargesItem(String name, Sprite sprite, int x, int y, MainGame game) {
        super(name, sprite, x, y, game);
    }

    public void renderCharges(Screen screen, int itemIndex) {
        int pixelsRemaining = 10 * numberOfChargesRemaining / numberOfCharges;
        int usedPixels = 10 - pixelsRemaining;
        int startingPoint = 8 + itemIndex * 16;
        screen.drawHUDRect(startingPoint, Constants.DEFAULT_SPRITE_SIZE * 5 + 17, pixelsRemaining, 1, 0xff44DB74);
        screen.drawHUDRect(startingPoint + pixelsRemaining, Constants.DEFAULT_SPRITE_SIZE * 5 + 17, usedPixels, 1, 0xffDB4744);
    }
}
