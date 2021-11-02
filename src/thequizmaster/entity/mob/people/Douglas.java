package thequizmaster.entity.mob.people;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.people.DouglasSprites;
import thequizmaster.graphics.people.KarlSprites;
import thequizmaster.graphics.people.NolanSprites;
import thequizmaster.input.Keyboard;

public class Douglas extends Player {
	
	public Douglas(Keyboard input, MainGame game) {
		super(input, game);
		setAnims();
		fname = "Douglas";
		sname = "Hooper";
		x = 74 * 34;
		y = 74 * 32;
		questionKnowledge.put("quotes", 2);
		questionKnowledge.put("language", 2);
	}
	
	public void setAnims() {
		standingSprites = DouglasSprites.douglasStandingSprites;
		walkingFowardAnim = DouglasSprites.douglasWalkingFrontSprites;
		walkingBackAnim = DouglasSprites.douglasWalkingBackSprites;
		walkingLeftAnim = DouglasSprites.douglasWalkingLeftSprites;
		walkingRightAnim = DouglasSprites.douglasWalkingRightSprites;
		wireTrapDeathAnim = DouglasSprites.douglasWireTrapDeathSprites;
		wireTrapCorpse = DouglasSprites.douglasWireTrapCorpse;
		sprite = standingSprites[2];
		HUDImage = DouglasSprites.douglasHUDFaceImage;

		chainGameWaiting = DouglasSprites.douglasChainGameWaiting;
		chainGamePull = DouglasSprites.douglasChainGamePull;
		chainGameDeath = DouglasSprites.douglasChainGameDeath;

		chainedSawChallengeAnim = DouglasSprites.douglasChainedSawChallenge;

		deathSawChallengeAnim = DouglasSprites.douglasDeathSawChallenge;

	}
	


}
