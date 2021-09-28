package thequizmaster.objects.traps;

import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.items.TrapSprites;
import thequizmaster.objects.AnimatedObject;

public class ChainGameSaw extends AnimatedObject {

	public ChainGameSaw(int x, int y, MainGame game) {
		super(TrapSprites.chainGameSawSprites, 10, true, x, y);
		game.addAlwaysDrawOver(this);
		game.addUpdateObject(this);
	}





}
