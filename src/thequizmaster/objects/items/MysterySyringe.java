package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;

public class MysterySyringe extends Item {

    public MysterySyringe(int x, int y, MainGame game){
        super("Mystery Syringe", ItemsSprites.mysterySyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        Player otherPlayer = game.isSpecficObjectCollidingWithPeople(player.interactionBox);
        if(otherPlayer == null){
            otherPlayer = player;
        }
        int chance = random.nextInt(10);
        if(chance > 5){
            otherPlayer.decreasePoisonLevel(30);
        } else {
            otherPlayer.increasePoisonLevel(30);
        }
        return true;
    }

    public void updateSelected(MainGame game){
        Player otherPlayer = game.isSpecficObjectCollidingWithPeople(game.player.interactionBox);
        if(otherPlayer != null){
            game.setInteractingMessage("Use Syringe on " + otherPlayer.fname + "?");
        }
    }

}
