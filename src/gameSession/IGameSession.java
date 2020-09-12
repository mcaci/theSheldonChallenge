/**
 *
 */
package gameSession;

import gameSession.move.EMossa;
import player.EPlayer;
import app.player.Player;

/**
 * Interface describing actions for the game session
 * @author nikiforos
 */
public interface IGameSession {
	
	/**
	 * Method to make the session start
	 * TODO: this is actually the main session run function
	 */
	public void startGame();
	
	/**
	 * Method that resolves the round and chooses the round winning player
	 * @param p1Move
	 * @param p2Move
	 * @return the round winning player
	 */
	public EPlayer getOutcome(EMossa p1Move, EMossa p2Move);


	/**
	 * Method to update the score and status of the round winning player
	 * @param roundWinner
	 */
	public void updateScoreAndStatus(EPlayer roundWinner);
	
	/**
	 * Method to return to get the session winning player
	 * @return the session winning player
	 */
	public Player getSessionWinner();
	
}
