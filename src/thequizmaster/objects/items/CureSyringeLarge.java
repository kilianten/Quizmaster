package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;

public class CureSyringeLarge extends Item {

    public CureSyringeLarge(int x, int y, MainGame game){
        super("Large Syringe", ItemsSprites.largeSyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        Player otherPlayer = game.isSpecficObjectCollidingWithPeople(player.interactionBox);
        if(otherPlayer != null){
            otherPlayer.increasePoisonLevel(70);
        } else {
            player.increasePoisonLevel(70);
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
