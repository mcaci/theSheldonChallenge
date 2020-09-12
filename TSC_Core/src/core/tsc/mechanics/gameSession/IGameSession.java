/**
 *
 */
package core.tsc.mechanics.gameSession;

import core.tsc.player.IPlayer;

/**
 * Interface describing actions for the game session
 * 
 * @author nikiforos
 */
public interface IGameSession extends Runnable {

	public static final int DEFAULT_WIN_SCORE = 3;

	public abstract boolean isGameOver();
	public abstract boolean checkIfGameWinner(IPlayer p);
	
}