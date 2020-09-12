package app.player;

import player.EPlayer;
import gameSession.move.EMossa;

public class AIPlayer extends Player {

	public AIPlayer(EPlayer p) {
		super(p);
	}

	public EMossa chooseMove() {
		return EMossa.values()[(int)(Math.random() * numPossibleChoices)];
	}
}
