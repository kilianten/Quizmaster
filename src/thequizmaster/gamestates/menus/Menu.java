package thequizmaster.gamestates.menus;

import thequizmaster.Constants;
import thequizmaster.Game;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;

import java.awt.*;

public class Menu {

    protected int menuSelection = 0;
    public MainGame game;
    protected Keyboard input;

    public Menu(MainGame game, Keyboard input) {
        input.enterReleased = false;
        this.input = input;
        this.game = game;
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

            }

    }
    


    public void render(Screen screen, Graphics g) {

    }


    private void drawQuestions(Graphics g) {
        FontMetrics metrics = g.getFontMetrics(Game.digestFont);
        int yOffset = 0;
        g.setColor(Color.WHITE);

        for(int i = 0; i < 3; i++) {
            g.drawString("questionOptions.get(i)", 190, 300 + yOffset);
            yOffset += 120;
        }


    }

    private void drawQuestionRects(Graphics g) {
        int yOffset = 0;
        g.setColor(new Color(0xff523C52));
        g.fillRect(150, 100, 1000, 100);
        for(int i = 0; i < 3; i++) {
            if(i == menuSelection) {
                g.setColor(new Color(Constants.SELECTED_RECT_COLOR));
                g.fillRect(150 - Constants.menuSelectionPadding, 250 + yOffset - Constants.menuSelectionPadding, 1000 + Constants.menuSelectionPadding * 2, 100 + Constants.menuSelectionPadding * 2);
                g.setColor(new Color(0xff523C52));
            }
            g.fillRect(150, 250 + yOffset, 1000, 100);
            yOffset += 120;
        }
    }

    public void renderHUDTEXT(Graphics g) {
    }

    public void swapPlayer() {
    }
}
