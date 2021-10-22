package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.people.KarlSprites;
import thequizmaster.graphics.people.NolanSprites;
import thequizmaster.input.Keyboard;

public class Karl extends Player {

    public Karl(Keyboard input, MainGame game) {
        super(input, game);
        setAnims();
        fname = "Karl";
        sname = "Kaplan";
        x = 74 * 34;
        y = 74 * 32;
        questionKnowledge.put("politics", 4);
        questionKnowledge.put("history", 1);
    }

    public void setAnims() {
        standingSprites = KarlSprites.karlStandingSprites;
        walkingFowardAnim = KarlSprites.karlWalkingFrontSprites;
        walkingBackAnim = KarlSprites.karlWalkingBackSprites;
        walkingLeftAnim = KarlSprites.karlWalkingLeftSprites;
        walkingRightAnim = KarlSprites.karlWalkingRightSprites;
        wireTrapDeathAnim = KarlSprites.karlWireTrapDeathSprites;
        wireTrapCorpse = KarlSprites.karlWireTrapCorpse;
        sprite = standingSprites[2];
        HUDImage = KarlSprites.karlHUDFaceImage;

        chainGameWaiting = KarlSprites.karlChainGameWaiting;
        chainGamePull = KarlSprites.karlChainGamePull;
        chainGameDeath = KarlSprites.karlChainGameDeath;

    }



}
