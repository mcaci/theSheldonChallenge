/**
 * 
 */
package player;

import gameSession.move.EMossa;

/**
 * Interface to manage any kind of results writers
 * @author nikiforos
 */
public abstract interface IPlayer {
	
	/**
	 * Gets the choice from the player
	 * @return the move chosen by the player
	 */
	public abstract EMossa chooseMove();

	/**
	 * Updates the score of the player
	 */
	public abstract void updatePunti();
}