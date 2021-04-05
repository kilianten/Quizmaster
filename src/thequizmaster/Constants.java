package thequizmaster;

import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.SpriteSheet;

public class Constants {
    public final static double FPS = 60.0;
    public final static double NANOSECONDS = 1000000000.0 / FPS;
    public final static String GAME_TITLE =  "The Quizmaster";
    
    public final static int DEFAULT_SPRITE_SIZE = 32;
    public final static int DEFAULT_ENTITY_SIZE = 64;
    
    //keys
    public final static int KEY_SLASH = 47;
    public final static int KEY_E = 69;
	public static final int AMMOUNT_OF_DARKNESS = 106;
	public static final float LIGHT_RADIUS = 850;
	
	//Probabilities
	public static final int CHANCE_OF_SPAWNING_TRIPWIRE = 3;
	public static final int SELECTED_RECT_COLOR = 0xffB47139;
	
	public static int screenWidth = 350;
	public static int screenHeight = screenWidth / 16 * 9;
	
	//questions
	public static int questionSelectedPadding = 5;
	public static int splitQuestionRows = 50;

}
