/**
 * 
 */
package resultsStorage;

import app.gameSession.GameSession;

/**
 * @author nikiforos
 *
 */
public interface IResultsStorage {
	
	public void writeResults(GameSession g) throws Exception;

}
