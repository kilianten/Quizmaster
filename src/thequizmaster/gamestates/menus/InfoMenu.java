package thequizmaster.gamestates.menus;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.hud.PaperHud;

public class InfoMenu extends Menu{

    private PaperHud paperHud;


    public InfoMenu(MainGame game, Keyboard input) {
        super(game, input);
        paperHud = new PaperHud();
    }

    public void render(Screen screen){
        paperHud.render(screen);
    }
}
