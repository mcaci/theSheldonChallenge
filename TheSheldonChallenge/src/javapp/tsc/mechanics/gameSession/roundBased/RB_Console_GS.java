package javapp.tsc.mechanics.gameSession.roundBased;

import javapp.tsc.ipc.com.ConsoleHook;
import javapp.tsc.player.impl.human.ConsolePlayer;
import core.tsc.ipc.IHook;
import core.tsc.mechanics.gameSession.classic.RoundBasedGS;
import core.tsc.player.impl.afc.RandomPlayer;

public final class RB_Console_GS extends RoundBasedGS {

	public RB_Console_GS(ConsolePlayer p1, RandomPlayer p2) {
		super(p1, p2);
	}

	/**
	 * Full constructor
	 */
	public RB_Console_GS(ConsolePlayer p1, RandomPlayer p2, int winScore) {
		super(p1, p2, winScore);
	}
	
	@Override
	protected void registerToHook(IHook hook) {
		ConsoleHook tmp = (ConsoleHook) hook;
		this.setLabelUpdater(tmp);
		tmp = null;
	}

}
