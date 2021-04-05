package thequizmaster.objects;

import thequizmaster.graphics.Screen;
import thequizmaster.graphics.Sprite;

public class CountdownTimer {
	private int duration;
	public Sprite sprite;
	public double updateRate;
	public long lastUpdated;
	public int currentSprite = 0;
	public boolean isFinished = false;
	
	public CountdownTimer(int duration) {
		duration *= 1000;
		this.sprite = Sprite.countdownDisplay[0];
		this.duration = duration;
		updateRate = duration / Sprite.countdownDisplay.length;
	}
	
	public void update() {
		
		if(System.currentTimeMillis() - lastUpdated > updateRate) {
			if(currentSprite < Sprite.countdownDisplay.length - 1) {
				currentSprite++;
				sprite = Sprite.countdownDisplay[currentSprite];
				lastUpdated = System.currentTimeMillis();
			} else {
				isFinished = true;
			}
		}
	}
}
