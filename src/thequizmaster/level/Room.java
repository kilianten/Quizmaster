package thequizmaster.level;

import thequizmaster.Constants;
import thequizmaster.gamestates.MainGame;
import thequizmaster.objects.traps.StartButton;
import thequizmaster.quizmode.MainEvent;

import java.awt.*;

public class Room {

    public int topLeftCornerX;
    public int topLeftCornerY;
    public int width;
    public int height;
    public String event;
    public boolean isUsed;
    public StartButton button;

    public Room(int topLeftCornerX, int topLeftCornerY, int width, int height){
        this.width = width;
        this.height = height;
        this.topLeftCornerX = topLeftCornerX * 32;
        this.topLeftCornerY = topLeftCornerY * 32;
        isUsed = false;
    }

    public int getCenterX(){
        return topLeftCornerX + (width * Constants.DEFAULT_SPRITE_SIZE)/2;
    }

    public int getCenterY(){
        return topLeftCornerY + (height * Constants.DEFAULT_SPRITE_SIZE)/2;
    }


}
