/**
 * 
 */
package app.gameSession.HUMvsCPU;

import gameSession.E2Players;
import app.gameSession.GameSession;
import app.player.AIPlayer;
import app.player.GUIHumanPlayer;

/**
 * @author nikiforos
 *
 */
public class GUI_HUMvsAI_GS extends GameSession {
	
	public GUI_HUMvsAI_GS() {
		super(new GUIHumanPlayer(E2Players.PLAYER1),
				new AIPlayer(E2Players.PLAYER2)
		);
	}

	public GUI_HUMvsAI_GS(int ws) {
		super(new GUIHumanPlayer(E2Players.PLAYER1),
				new AIPlayer(E2Players.PLAYER2),
				ws
		);
	}
}
