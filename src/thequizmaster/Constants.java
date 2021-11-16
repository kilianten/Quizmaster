package thequizmaster;

import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;
import thequizmaster.objects.items.CureSyringeLarge;
import thequizmaster.objects.items.Item;

import java.util.ArrayList;

public class Constants {
    public final static double FPS = 60.0;
    public final static double NANOSECONDS = 1000000000.0 / FPS;
    public final static String GAME_TITLE =  "The Quizmaster";

    public final static ArrayList<String> MAINEVENTGAMEMODES = new ArrayList<String>(){{
		add("ChainGame");
	}};

	public final static ArrayList<String> GAMEMODES = new ArrayList<String>(){{
		add("ChainGame");
		add("SawDifficulty");
	}};
    
    public final static int DEFAULT_SPRITE_SIZE = 32;
    public final static int DEFAULT_ENTITY_SIZE = 64;
    
    //keys
    public final static int KEY_SLASH = 47;
    public final static int KEY_E = 69;
	public static final int AMMOUNT_OF_DARKNESS = 106;
	public static final float LIGHT_RADIUS = 850;
	
	//Probabilities
	public static final int CHANCE_OF_SPAWNING_TRIPWIRE = 10;
	public static final int SELECTED_RECT_COLOR = 0xffB47139;
	
	public static int screenWidth = 350;
	public static int screenHeight = screenWidth / 16 * 9;
	
	//questions
	public static int questionSelectedPadding = 5;
	public static int splitQuestionRows = 50;

	public static int[] poisonGradient = new int[] {0xffa92562,0xffc03358,0xffd2484c,0xffdd5f3f,0xffe27932,0xffe29426,0xffdbae23,0xffcec82f,0xffbbe24a, 0xffa0fa6e};

    public static int menuSelectionPadding = 20;
}
