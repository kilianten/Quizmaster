package thequizmaster.objects.traps;

import javax.sound.sampled.FloatControl;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;
import thequizmaster.objects.Audio;
import thequizmaster.objects.CollidableObject;
import thequizmaster.objects.Hitbox;

public class TripWire extends CollidableObject {
	
	private boolean tripped = false;
	private Sprite sprite = Sprite.tripWire;
	private Audio tripwireSound = new Audio();
	private float tempVolume;
	
	public TripWire(int x, int y) {
		this.y = y;
		this.x = x;
		hitbox = new Hitbox(x, y, 2, 64, 15, 2);
	}

	public void render(Screen screen) {
		screen.renderObject(x, y, sprite);
	}
	
	public void update() {
		FloatControl volume = (FloatControl) tripwireSound.clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(tempVolume);
        tripwireSound.play();
        tempVolume = -60f;
	}
	
	public boolean checkCollision(int playerX, int playerY, int playerDir){
		int xOffset = 0;
		if(playerDir == 3) {
			xOffset += 16;
		}
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < sprite.YSIZE; j++) {
				if(playerX == i + x + xOffset && playerY == j + y) {
					tripwireSound.play();
					tripped = true;
					return true;
				}
			}
		}
		return false;
	}
	
	public void hasCollided() {
		tripwireSound.play();
	}
	
	
}
