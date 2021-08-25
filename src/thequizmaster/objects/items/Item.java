package thequizmaster.objects.items;

import thequizmaster.graphics.Sprite;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;

public class Item extends CollidableObject {

    public String name;
    public Sprite sprite;
    private Hitbox hitbox;
    private int x;
    private int y;

    public Item(String name, Sprite sprite, Hitbox hitbox, int x, int y){
        this.name = name;
        this.sprite = sprite;
        this.hitbox = hitbox;
        this.x = x;
        this.y = y;
    }

    public void use(){

    }

}
