package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;

public class CureSyringeLarge extends Item {

    public CureSyringeLarge(int x, int y, MainGame game){
        super("Large Syringe", ItemsSprites.largeSyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        player.increasePoisonLevel(70);
        return true;
    }

}
