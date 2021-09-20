package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.items.ItemsSprites;
import thequizmaster.objects.GameObject;
import thequizmaster.objects.traps.TripWire;

public class Wirecutters extends ChargesItem {

    public Wirecutters(int x, int y, MainGame game) {
        super("Wirecutters", ItemsSprites.wirecutters, x, y, game);
        numberOfCharges = 2;
        numberOfChargesRemaining = numberOfCharges;
    }

    public boolean use(Player player, MainGame game){
        GameObject tripwire = game.isSpecficObjectColliding(player.interactionBox, "TripWire");
        if(tripwire != null){
            game.removeCollidableObject(tripwire);
            game.removeDrawOverObject(tripwire);
            return true;
        } else {
            return false;
        }
    }

}
