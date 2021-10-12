package thequizmaster.objects.items;

import thequizmaster.Constants;
import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Item extends CollidableObject {

    public String name;

    public static Map<String, Integer> spawnChances = new HashMap<>() {{
        put("Large Syringe", 4);
        put("Small Syringe", 7);
        put("Mystery Syringe", 4);
        put("Poison Syringe", 2);
        put("Wirecutters", 1);
        put("Book", 100);
    }};

    public static Random random = new Random();

    public Item(String name, Sprite sprite, int x, int y, MainGame game){
        this.name = name;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        hitbox = new Hitbox(x, y, sprite);
        game.addAlwaysDrawOver(this);
    }

    public boolean use(Player player, MainGame game){
        return true;
    }

    public void renderHUDIcon(Screen screen, int itemIndex) {
        this.x = 5;
        screen.renderFixedObject(5 + itemIndex * 16,Constants.DEFAULT_SPRITE_SIZE * 5 + 5, sprite);
    }

    public void updatePosition(int x, int y){
        this.x = x;
        this.y = y;
        this.hitbox.x = x;
        this.hitbox.y = y;
    }

    public void hasCollided(MainGame mainGame) {
        mainGame.setInteractingMessage("Pick Up " + name + "?");
    }

    public void isInteractedWith(MainGame mainGame) {
        mainGame.removeGameObject(this);
        mainGame.removeInteractableObject(this);
        mainGame.givePlayerItem(this);
    }

    public static String getRandomItem(){
        int total = 0;
        for (Map.Entry<String, Integer> entry : spawnChances.entrySet()) {
            total += entry.getValue();
        }
        int randomInt = random.nextInt(total);
        int counter = 0;
        for (Map.Entry<String, Integer> entry : spawnChances.entrySet()) {
            if(randomInt >= counter && randomInt < (entry.getValue() + counter)){
                return entry.getKey();
            } else {
                counter += entry.getValue();
            }
        }
        return null;
    }


}
