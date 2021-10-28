package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.ItemsSprites;
import thequizmaster.objects.GameObject;

public class PoisonSyringe extends Item {

    public PoisonSyringe(int x, int y, MainGame game){
        super("Poison Syringe", ItemsSprites.poisonSyringe, x, y, game);
    }

    public boolean use(Player player, MainGame game){
        Player otherPlayer = game.isSpecficObjectCollidingWithPeople(player.interactionBox);
        if(otherPlayer != null){
            System.out.println("poisoned other");
            otherPlayer.decreasePoisonLevel(40);
        } else {
            player.decreasePoisonLevel(40);
        }
        return true;
    }

    public void updateSelected(MainGame game){
        Player otherPlayer = game.isSpecficObjectCollidingWithPeople(game.player.interactionBox);
        if(otherPlayer != null){
            game.setInteractingMessage("Poison " + otherPlayer.fname + "?");
        }
    }

}
