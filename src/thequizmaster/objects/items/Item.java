package thequizmaster.objects.items;

import thequizmaster.Constants;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;

public class Item extends CollidableObject {

    public String name;

    public Item(String name, Sprite sprite, int x, int y){
        this.name = name;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }

    public void use(){

    }

    public void renderHUDIcon(Screen screen, int itemIndex) {
        this.x = 5;
        screen.renderFixedObject(5 + itemIndex * 16,Constants.DEFAULT_SPRITE_SIZE * 5 + 5, sprite);
    }
}
