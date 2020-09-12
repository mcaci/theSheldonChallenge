package app.player;

import gameSession.E2Players;
import gameSession.EMossa;

public class AIPlayer extends Player {

	public AIPlayer(E2Players p) {
		super(p);
	}

	public EMossa chooseMove() {
		return EMossa.values()[(int)(Math.random() * numPossibleChoices)];
	}
}
