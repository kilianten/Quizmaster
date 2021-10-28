package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;

public class CureSyringeSmall extends Item {

    public CureSyringeSmall(int x, int y, MainGame game){
        super("Small Syringe", ItemsSprites.smallSyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        Player otherPlayer = game.isSpecficObjectCollidingWithPeople(player.interactionBox);
        if(otherPlayer != null){
            otherPlayer.increasePoisonLevel(40);
        } else {
            player.increasePoisonLevel(40);
        }
        return true;
    }

    public void updateSelected(MainGame game){
        Player otherPlayer = game.isSpecficObjectCollidingWithPeople(game.player.interactionBox);
        if(otherPlayer != null){
            game.setInteractingMessage("Cure " + otherPlayer.fname + "?");
        }
    }

}
