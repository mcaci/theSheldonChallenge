/**
 * 
 */
package app.gameSession.AIvsAI_GS;

import gameSession.E2Players;
import app.gameSession.GameSession;
import app.player.AIPlayer;

/**
 * @author nikiforos
 *
 */
public class AIvsAI_GS extends GameSession {

	public AIvsAI_GS() {
		super(new AIPlayer(E2Players.PLAYER1),
				new AIPlayer(E2Players.PLAYER2)
		);
	}

	public AIvsAI_GS(int ws) {
		super(new AIPlayer(E2Players.PLAYER1),
				new AIPlayer(E2Players.PLAYER2),
				ws
		);
	}

}
