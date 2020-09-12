/**
 *
 */
package interfaces;

import player.Player;

/**
 * Interface describing actions for the game session
 * @author nikiforos
 */
public interface IGameSession extends Runnable {
		
	/**
	 * Method to return to get the session winning player
	 * @return the session winning player
	 */
	public Player getSessionWinner();
		
}