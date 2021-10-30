package thequizmaster.objects.traps;

import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.items.TrapSprites;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;

public class TV extends CollidableObject {

    private Sprite[] tvNumbers;
    public int currentNumber;

    public TV(int x, int y, MainGame game) {
        this.y = y;
        this.x = x;
        hitbox = new Hitbox(x, y, 50, 25, 8, 15);
        sprite =  TrapSprites.tvSprite;
        canWalkThrough = false;
        game.addDrawObject(this);
        game.level.addCollidableObject(this);
        tvNumbers = TrapSprites.tvNumbers;
        currentNumber = 0;
    }

    public void render(Screen screen) {
        super.render(screen);
        screen.renderObject(x + 15, y + 10, tvNumbers[currentNumber]);
    }

}
