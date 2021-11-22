package thequizmaster.gamestates.menus;

import thequizmaster.Constants;
import thequizmaster.Game;
import thequizmaster.gamestates.GameState;
import thequizmaster.gamestates.MainGame;
import thequizmaster.gamestates.menus.Menu;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.people.NolanSprites;
import thequizmaster.input.Keyboard;

import java.awt.*;

public class MainMenu extends GameState {

    private Keyboard input;
    protected int menuSelection = 0;

    public MainMenu(Keyboard input) {
        this.input = input;
    }



    public void update() {
        getPlayerInput();



    }

    public void getPlayerInput(){

        if (input.upReleased) {
            input.upReleased = false;
            menuSelection--;
            if(menuSelection < 0) {
                menuSelection = 3;
            }
        }
        if (input.downReleased) {
            input.downReleased = false;
            menuSelection++;
            menuSelection %= 3;
        }
        if (input.enterReleased) {
            startGame = true;
        }
    }

    public void render(Screen screen) {
        screen.renderFixedObject(menuSelection * 20, 0, NolanSprites.nolanStandingSprites[1]);
    }


    public void renderHUDTEXT(Graphics g) {
    }

}
