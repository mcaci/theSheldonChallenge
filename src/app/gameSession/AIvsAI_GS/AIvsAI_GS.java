/**
 * 
 */
package app.gameSession.AIvsAI_GS;

import player.EPlayer;
import app.gameSession.GameSession;
import app.player.AIPlayer;

/**
 * @author nikiforos
 *
 */
public class AIvsAI_GS extends GameSession {

	public AIvsAI_GS() {
		super(new AIPlayer(EPlayer.PLAYER1),
				new AIPlayer(EPlayer.PLAYER2)
		);
	}

	public AIvsAI_GS(int ws) {
		super(new AIPlayer(EPlayer.PLAYER1),
				new AIPlayer(EPlayer.PLAYER2),
				ws
		);
	}

}
