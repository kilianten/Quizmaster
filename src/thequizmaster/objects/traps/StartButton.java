package thequizmaster.objects.traps;

import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.TrapSprites;
import thequizmaster.level.Level;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;

public class StartButton extends CollidableObject
{
    public StartButton(int x, int y, MainGame game, Level level) {
        this.y = y;
        this.x = x;
        hitbox = new Hitbox(x, y, 50, 25, 8, 15);
        sprite =  TrapSprites.startButtonSprite;
        canWalkThrough = false;
        game.addDrawObject(this);
        level.addInteractableObject(this);
        level.addCollidableObject(this);
    }

    public void hasCollided(MainGame mainGame) {
        mainGame.setInteractingMessage("Start Quiz?");
    }

    public void isInteractedWith(MainGame mainGame) {
        mainGame.player.dir = 0;
        mainGame.removeInteractableObject(this);
    }
}
