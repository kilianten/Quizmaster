package thequizmaster.quizmode;

import thequizmaster.gamestates.MainGame;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;

import java.util.ArrayList;

public class MainEvent extends QuizMode{

    protected static String gameName;
    public static int maxPlayers;
    public static int minWidth;
    public static int minHeight;

    protected Room room;

    public MainEvent(Keyboard input, Room room, MainGame game){
        this.room = room;
        this.game = game;
        this.input = input;
    }

    public static Room isSuitableRoomAvailable(ArrayList<Room> rooms){
        for(Room room: rooms){
            if(room.width > minWidth &&  room.height > minHeight){
                return room;
            }
        }
        return null;
    }

}
