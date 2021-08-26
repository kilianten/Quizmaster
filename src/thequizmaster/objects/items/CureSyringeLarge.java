package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.graphics.items.ItemsSprites;

public class CureSyringeLarge extends Item {

    public CureSyringeLarge(int x, int y){
        super("Large Syringe", ItemsSprites.largeSyringe, x, y);
    }

    public void use(Player player){
        player.increasePoisonLevel(70);
    }

}
