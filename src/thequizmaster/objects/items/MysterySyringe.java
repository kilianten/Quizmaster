package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;

public class MysterySyringe extends Item {

    public MysterySyringe(int x, int y, MainGame game){
        super("Mystery Syringe", ItemsSprites.mysterySyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        int chance = random.nextInt(10);
        if(chance > 5){
            player.decreasePoisonLevel(30);
        } else {
            player.increasePoisonLevel(30);
        }
        return true;
    }

}
