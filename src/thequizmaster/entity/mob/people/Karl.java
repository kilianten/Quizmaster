package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.people.KarlSprites;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;

public class Karl extends Player {

    public Karl(Keyboard input, MainGame game) {
        super(input, game);
        setAnims();
        fname = "Karl";
        x = 74 * 34;
        y = 74 * 32;
    }

    public void setAnims() {
        standingSprites = KarlSprites.karlStandingSprites;
        walkingFowardAnim = KarlSprites.karlWalkingFrontSprites;
        walkingBackAnim = KarlSprites.karlWalkingBackSprites;
        walkingLeftAnim = KarlSprites.karlWalkingLeftSprites;
        walkingRightAnim = KarlSprites.karlWalkingRightSprites;
        wireTrapDeathAnim = KarlSprites.karlWireTrapDeathSprites;
        wireTrapCorpse = KarlSprites.karlWireTrapCorpse;
        sprite = standingSprites[0];
        HUDImage = KarlSprites.karlHUDFaceImage;
    }



}
