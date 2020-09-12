/**
 * 
 */
package interfaces;

import player.Player;

/**
 * @author nikiforos
 *
 */
public interface IGameRound {
	
	/**
	 * @return the player that wins the round
	 */
	public Player executeRound();

}
