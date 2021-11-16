package thequizmaster.quizmode;

import thequizmaster.gamestates.MainGame;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Room;

import java.util.ArrayList;
import java.util.Collections;

public class MainEvent extends QuizMode{

    protected static String gameName;
    public static int maxPlayers;

    protected Room room;

    public MainEvent(Keyboard input, Room room, MainGame game){
        this.room = room;
        this.game = game;
        this.input = input;
    }

    public static Room isSuitableRoomAvailable(ArrayList<Room> rooms, int minWidth, int minHeight){
        Collections.shuffle(rooms);
        for(Room room: rooms){
            if(room.width >= minWidth &&  room.height >= minHeight){
                return room;
            }
        }
        return null;
    }



}
