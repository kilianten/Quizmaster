package thequizmaster.level;

public class Room {

    public int topLeftCornerX;
    public int topLeftCornerY;
    public int width;
    public int height;

    public Room(int topLeftCornerX, int topLeftCornerY, int width, int height){
        this.width = width;
        this.height = height;
        this.topLeftCornerX = topLeftCornerX * 32;
        this.topLeftCornerY = topLeftCornerY * 32;
    }

}
