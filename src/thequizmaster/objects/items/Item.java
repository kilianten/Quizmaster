package thequizmaster.objects.items;

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

}
