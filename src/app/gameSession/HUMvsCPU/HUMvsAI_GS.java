/**
 * 
 */
package app.gameSession.HUMvsCPU;

import player.EPlayer;
import app.gameSession.GameSession;
import app.player.AIPlayer;
import app.player.HumanPlayer;

/**
 * @author nikiforos
 *
 */
public class HUMvsAI_GS extends GameSession {
	
	public HUMvsAI_GS() {
		super(new HumanPlayer(EPlayer.PLAYER1),
				new AIPlayer(EPlayer.PLAYER2)
		);
	}

	public HUMvsAI_GS(int ws) {
		super(new HumanPlayer(EPlayer.PLAYER1),
				new AIPlayer(EPlayer.PLAYER2),
				ws
		);
	}
}
