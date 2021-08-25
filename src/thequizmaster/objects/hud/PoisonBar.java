package thequizmaster.objects.hud;


import thequizmaster.Constants;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class PoisonBar {
	public Sprite sprite;
	public int x, y;

	public PoisonBar() {
		this.y = Constants.DEFAULT_SPRITE_SIZE * 5 - 2;
		this.x = Constants.DEFAULT_SPRITE_SIZE * 7;
		this.sprite = Sprite.poisonBar;
	}

	public void render(Screen screen, int poisonLevel, Sprite HUDPlayerImage) {
		int colourIndex = (int) Math.floor(poisonLevel/10) - 1;
		screen.drawHUDRect(x + 9, y + 13, poisonLevel, 4, Constants.poisonGradient[colourIndex]);
		screen.renderFixedObject(x, y, sprite);
		screen.renderFixedObject(x, y, HUDPlayerImage);
	}
}
