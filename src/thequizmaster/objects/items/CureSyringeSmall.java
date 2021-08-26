package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.graphics.items.ItemsSprites;

public class CureSyringeSmall extends Item {

    public CureSyringeSmall(int x, int y){
        super("Small Syringe", ItemsSprites.smallSyringe, x, y);
    }

    public void use(Player player){
        player.increasePoisonLevel(30);
    }

}
