/**
 * 
 */
package resultsStorage;

import app.gameSession.GameSession;

/**
 * Interface to manage any kind of results writers
 * @author nikiforos
 */
public interface IResultWriter {
	
	/**
	 * This method is responsible to write a game session through some storage method
	 * @param g the GameSession we want to store
	 * @throws Exception
	 */
	public void write(GameSession g) throws Exception;

}
