package thequizmaster.objects;

import thequizmaster.graphics.Sprite;

public class AnimatedObject extends GameObject{

    protected int imagesIndex = 0;
    protected int counter = 0;
    protected int updateRate;
    protected int spritesLength;

    protected Sprite[] sprites;
    protected boolean isCyclingAnimation;

    public AnimatedObject(Sprite[] sprites, int updateRate, boolean isCyclingAnimation, int x, int y){
        this.sprites = sprites;
        sprite = sprites[0];
        this.updateRate = updateRate;
        spritesLength = sprites.length;
        this.isCyclingAnimation = isCyclingAnimation;
        this.x = x;
        this.y = y;
    }

    public void update(){
        counter++;
        if (counter >= updateRate){
            if(isCyclingAnimation){
                imagesIndex += 1;
                imagesIndex %= spritesLength;
                sprite = sprites[imagesIndex];
                counter = 0;
            } else {
                endAnimation();
            }
        }
    }

    public void endAnimation(){

    }

}
