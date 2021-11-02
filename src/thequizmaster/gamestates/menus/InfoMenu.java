package thequizmaster.gamestates.menus;
import thequizmaster.Game;
import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.input.Keyboard;
import thequizmaster.objects.hud.PaperHud;

import java.awt.*;

public class InfoMenu extends Menu{

    private PaperHud paperHud;
    public int playerIndex;

    public InfoMenu(MainGame game, Keyboard input) {
        super(game, input);
        paperHud = new PaperHud();
        playerIndex = 0;
    }

    public void render(Screen screen, Graphics g){
        int offset = 0;
        paperHud.render(screen);
        if(getCurrentPlayer().getPlayerMainSprite().SIZE == 96){
            offset = 16;
        }
        screen.renderFixedObject( 230 - offset, 30 - offset, getCurrentPlayer().getPlayerMainSprite());
        drawKnowledgeBars(screen);
    }

    public void renderHUDTEXT(Graphics g) {
        g.setFont(Game.titleFont);
        if(getCurrentPlayer().isDead){
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }

        g.drawString(getCurrentPlayer().fname + " " + getCurrentPlayer().sname, 215, 205);

        g.setColor(Color.BLACK);
        g.setFont(Game.digestFont);
        drawKnowledgeMap(g);
    }

    private void drawKnowledgeMap(Graphics g) {
        int yOffset = 0;
        for(String category: getCurrentPlayer().questionKnowledge.keySet()){
            g.drawString(category + ":", 235, 250 + yOffset);
            yOffset += 24;
        }
    }

    public Player getCurrentPlayer(){
        return game.allPeopleNeverChange.get(playerIndex);
    }

    public void swapPlayer() {
        playerIndex++;
        playerIndex %= game.allPeopleNeverChange.size();
    }

    private void drawKnowledgeBars(Screen screen) {
        int yOffset = 0;
        int xOffset;
        for(Integer count: getCurrentPlayer().questionKnowledge.values()){
            xOffset = 0;
            for(int x = 0; x < count; x++){
                screen.renderFixedObject(98 + xOffset, 53 + yOffset, Sprite.knowledgeBarSprite);
                xOffset += 13;
            }
            yOffset += 6;
        }
    }
}
