package javapp.tsc.mechanics.gameSession;

import javapp.tsc.ipc.com.ConsoleHook;
import javapp.tsc.player.impl.human.ConsolePlayer;
import core.tsc.ipc.IGameHook;
import core.tsc.mechanics.gameSession.classic.RoundBasedGS;
import core.tsc.player.impl.afc.RandomPlayer;

public final class RB_Console_GS extends RoundBasedGS {

	public RB_Console_GS(final ConsolePlayer p1, final RandomPlayer p2) {
		super(p1, p2);
	}

	/**
	 * Full constructor
	 */
	public RB_Console_GS(final ConsolePlayer p1, final RandomPlayer p2, final int winScore) {
		super(p1, p2, winScore);
	}
	
	@Override
	protected final void registerToHook(final IGameHook hook) {
		ConsoleHook tmp;
		if(hook != null){
			tmp = (ConsoleHook) hook;
		}
		else {
			tmp = new ConsoleHook();
		}
		this.setLabelUpdater(tmp);
		tmp = null;
	}

}
