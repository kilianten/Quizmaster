package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;

public class PoisonSyringe extends Item {

    public PoisonSyringe(int x, int y, MainGame game){
        super("Poison Syringe", ItemsSprites.poisonSyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        player.decreasePoisonLevel(40);
        return true;
    }

}
