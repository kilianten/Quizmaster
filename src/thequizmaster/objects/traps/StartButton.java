package thequizmaster.objects.traps;

import thequizmaster.Constants;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.TrapSprites;
import thequizmaster.level.Level;
import thequizmaster.level.Room;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;
import thequizmaster.quizmode.ChainGame;
import thequizmaster.quizmode.SawChallenge;

public class StartButton extends CollidableObject
{

    public String event;
    private MainGame game;
    private Room room;

    public StartButton(Room room, MainGame game, Level level) {
        this.room = room;
        this.game = game;
        event = room.event;
        this.x = room.topLeftCornerX + (room.width * Constants.DEFAULT_SPRITE_SIZE)/2;
        this.y = room.topLeftCornerY + ( room.height * Constants.DEFAULT_SPRITE_SIZE)/2;
        hitbox = new Hitbox(x, y, 6, 40, 25, 22);
        sprite =  TrapSprites.startButtonSprite;
        canWalkThrough = false;
        game.addDrawObject(this);
        level.addInteractableObject(this);
        level.addCollidableObject(this);
    }

    public void hasCollided(MainGame mainGame) {
        mainGame.setInteractingMessage("Start Quiz?");
    }

    public void isInteractedWith(MainGame mainGame) {
        mainGame.player.dir = 0;
        createEvent();
    }

    public void createEvent(){
        switch(event) {
            case "ChainGame":
                game.quiz = new ChainGame(game.key, room, game);
                break;
            case "SawDifficulty":
                game.quiz = new SawChallenge(game.key, room, game);
                break;
            default:
                break;
        }

    }

}
