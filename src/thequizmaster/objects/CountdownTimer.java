package thequizmaster.objects;

import thequizmaster.graphics.Sprite;

public class CountdownTimer {
	private int duration;
	public Sprite sprite;
	
	public CountdownTimer(int duration) {
		this.sprite = Sprite.countdownDisplay;
		this.duration = duration;
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}
}
