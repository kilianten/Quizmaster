package thequizmaster.objects;

public class Delay {

    private long creationTime;
    private int duration;
    public boolean isFinished;
    public boolean isHalfway;

    public Delay(int durationSeconds){
        this.duration = durationSeconds * 1000;
        this.creationTime = System.currentTimeMillis();
        isHalfway = false;
    }

    public void update() {
        if(System.currentTimeMillis() - creationTime >= duration){
            isFinished = true;
        } else if(System.currentTimeMillis() - creationTime >= duration / 2){
            isHalfway = true;
        }
    }
}
