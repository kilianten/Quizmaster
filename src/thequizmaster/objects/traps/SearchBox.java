package thequizmaster.objects.traps;


import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.TrapSprites;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;

public class SearchBox extends CollidableObject {

    public SearchBox(int x, int y) {
        sprite =  TrapSprites.searchBoxSprite;
        y -= sprite.SIZE/2;
        x -= sprite.SIZE/2;
        this.x = x;
        this.y = y;
        hitbox = new Hitbox(x, y, 50, 25, 8, 15);
        canWalkThrough = false;
    }

    public void hasCollided(MainGame mainGame) {
        mainGame.setInteractingMessage("Search Box For Items?");
    }

    public void isInteractedWith(MainGame mainGame) {
        mainGame.player.x = x + 33;
        mainGame.player.y = y + 25;
        mainGame.player.dir = 0;
        mainGame.removeInteractableObject(this);
        mainGame.removePlayerControl();
        mainGame.createSearchBoxTrapQuiz();
    }

}
