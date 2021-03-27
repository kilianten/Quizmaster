package thequizmaster.graphics;

import thequizmaster.entity.mob.Mob;

public class Animation {
	
	public int currentAnimIndex;
	public long lastUpdate;
	private Sprite[] spriteSet;
	private double updateTime;
	private Mob entity;
	public boolean isFinished = false;
	private int startTime;
	private boolean hasStarted;
	
	public Animation(double currentAnimUpdateTime, Sprite[] spriteSet, Mob entity, int startTime) {
		currentAnimIndex = 0;
		lastUpdate = System.currentTimeMillis();
		updateTime = currentAnimUpdateTime * 100;
		this.entity = entity;
		this.spriteSet = spriteSet;
		this.startTime = startTime * 100;
		hasStarted = false;
	}
	
	public void update() {
		if(System.currentTimeMillis() - lastUpdate > startTime) {
			hasStarted = true;
		}
		if(System.currentTimeMillis() - lastUpdate > updateTime && hasStarted) {
			if(currentAnimIndex == spriteSet.length - 1) {
				isFinished = true;
			} else {
				currentAnimIndex++;
				entity.sprite = spriteSet[currentAnimIndex];
				lastUpdate = System.currentTimeMillis();
			}
		}
	}
	
	
}
