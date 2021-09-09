package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;

public class CureSyringeSmall extends Item {

    public CureSyringeSmall(int x, int y, MainGame game){
        super("Small Syringe", ItemsSprites.smallSyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        player.increasePoisonLevel(30);
        return true;
    }

}
