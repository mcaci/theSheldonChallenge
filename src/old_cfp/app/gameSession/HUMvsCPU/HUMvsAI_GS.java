/**
 * 
 */
package app.gameSession.HUMvsCPU;

import gameSession.E2Players;
import app.gameSession.GameSession;
import app.player.AIPlayer;
import app.player.HumanPlayer;

/**
 * @author nikiforos
 *
 */
public class HUMvsAI_GS extends GameSession {
	
	public HUMvsAI_GS() {
		super(new HumanPlayer(E2Players.PLAYER1),
				new AIPlayer(E2Players.PLAYER2)
		);
	}

	public HUMvsAI_GS(int ws) {
		super(new HumanPlayer(E2Players.PLAYER1),
				new AIPlayer(E2Players.PLAYER2),
				ws
		);
	}
}
