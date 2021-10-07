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
	private boolean isCyclical;
	
	public Animation(double currentAnimUpdateTime, Sprite[] spriteSet, Mob entity, int startTime, boolean isCyclical) {
		currentAnimIndex = 0;
		lastUpdate = System.currentTimeMillis();
		updateTime = currentAnimUpdateTime * 100;
		this.entity = entity;
		this.spriteSet = spriteSet;
		this.startTime = startTime * 100;
		hasStarted = false;
		this.isCyclical = isCyclical;
	}
	
	public void update() {
		if(System.currentTimeMillis() - lastUpdate > startTime) {
			hasStarted = true;
		}
		if(System.currentTimeMillis() - lastUpdate > updateTime && hasStarted) {
			if(currentAnimIndex == spriteSet.length - 1) {
				if(isCyclical){
					currentAnimIndex = 0;
				} else {
					isFinished = true;
				}
			} else {
				currentAnimIndex++;
				entity.sprite = spriteSet[currentAnimIndex];
				lastUpdate = System.currentTimeMillis();
			}
		}
	}
	
	
}
