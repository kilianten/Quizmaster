package thequizmaster.objects.hud;


import thequizmaster.Constants;
import thequizmaster.entity.mob.Player;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class InventoryBar {
    public Sprite sprite;
    public Sprite currentSelectedSprite;
    public int x, y;

    public InventoryBar() {
        this.y = Constants.DEFAULT_SPRITE_SIZE * 5 + 5;
        this.x = 5;
        sprite = Sprite.inventoryBar;
        currentSelectedSprite = Sprite.currentSelectedSprite;
    }

    public void render(Screen screen) {
        screen.renderFixedObject(x, y, sprite);
    }

    public void renderSelected(Screen screen, int playerSelection) {
        screen.renderFixedObject(x + playerSelection * 16, y, currentSelectedSprite);
    }
}
