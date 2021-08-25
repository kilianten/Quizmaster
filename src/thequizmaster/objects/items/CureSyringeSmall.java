package thequizmaster.objects.items;

import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;
import thequizmaster.objects.Hitbox;

public class CureSyringeSmall extends Item {

    public CureSyringeSmall(int x, int y){
        super("Small Syringe", ItemsSprites.smallSyringe, x, y);
        hitbox = new Hitbox(x, y, 16, 16, 0, 0);
    }

    public void hasCollided(MainGame mainGame) {
        mainGame.setInteractingMessage("Pick Up " + name + "?");
    }

    public void isInteractedWith(MainGame mainGame) {
        mainGame.removeGameObject(this);
        mainGame.removeInteractableObject(this);
    }

}
