package thequizmaster.objects.hud;


import thequizmaster.Constants;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class PaperHud {
	public Sprite sprite;
	public int x, y;

	public PaperHud() {
		this.y = 5;
		this.x = 5;
		this.sprite = Sprite.paperSprite;
	}

	public void render(Screen screen) {
		screen.renderFixedObject(x, y, sprite);
	}
}
