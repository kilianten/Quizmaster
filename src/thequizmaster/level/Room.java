package thequizmaster.level;

public class Room {

    private int topLeftIndex;
    public int width;
    public int height;

    public Room(int topLeftIndex, int width, int height){
        this.topLeftIndex = topLeftIndex;
        this.width = width;
        this.height = height;
    }
}
