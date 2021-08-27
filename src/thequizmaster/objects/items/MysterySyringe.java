package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.graphics.items.ItemsSprites;

public class MysterySyringe extends Item {

    public MysterySyringe(int x, int y){
        super("Mystery Syringe", ItemsSprites.mysterySyringe, x, y);
    }

    public void use(Player player){
        int chance = random.nextInt(10);
        if(chance > 5){
            player.decreasePoisonLevel(30);
        } else {
            player.increasePoisonLevel(30);
        }
    }

}
