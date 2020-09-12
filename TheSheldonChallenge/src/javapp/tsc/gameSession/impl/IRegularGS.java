/**
 * 
 */
package javapp.tsc.gameSession.impl;

import core.tsc.gameSession.IGameSession;
import core.tsc.player.IPlayer;

/**
 * @author nikiforos
 * 
 */
public interface IRegularGS extends IGameSession {

	public abstract IPlayer getP1();

	public abstract IPlayer getP2();

}
