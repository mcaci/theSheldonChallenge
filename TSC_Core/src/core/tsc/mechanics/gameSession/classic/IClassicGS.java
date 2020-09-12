/**
 * 
 */
package core.tsc.mechanics.gameSession.classic;

import core.tsc.mechanics.gameSession.IGameSession;
import core.tsc.player.IPlayer;

/**
 * @author nikiforos
 * 
 */
public interface IClassicGS extends IGameSession {

	public abstract IPlayer getP1();
	public abstract IPlayer getP2();

}
