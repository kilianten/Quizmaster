package thequizmaster.objects.traps;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.TrapSprites;
import thequizmaster.objects.GameObject;

public class ChainGameLight extends GameObject {

    public Player player;

    public ChainGameLight(int x, int y, MainGame game, Player player){
        this.player = player;
        this.sprite = TrapSprites.chainGameOffLight;
        this.x = x;
        this.y = y;
        game.addAlwaysDrawOver(this);
    }

    public void turnOff(){
        this.sprite = TrapSprites.chainGameOffLight;
    }

    public void turnOn(){
        this.sprite = TrapSprites.chainGameOnLight;
    }

}
