package javapp.tsc.mechanics.gameSession;

import javapp.tsc.ipc.com.SwingLabelHook;
import javapp.tsc.player.impl.human.SwingPlayer;
import core.tsc.ipc.IGameHook;
import core.tsc.mechanics.gameSession.classic.RoundBasedGS;

public final class RB_GUI_2P_GS extends RoundBasedGS {

	/**
	 * Each concrete implementation of a GameSession needs to provide the two
	 * players and the ruleSet
	 */
	public RB_GUI_2P_GS(final SwingPlayer p1, final SwingPlayer p2) {
		super(p1, p2);
	}

	/**
	 * Full constructor
	 */
	public RB_GUI_2P_GS(final SwingPlayer p1, final SwingPlayer p2, final int winScore) {
		super(p1, p2, winScore);
	}
	
	@Override
	protected final void registerToHook(final IGameHook hook){
		final SwingLabelHook tmp = (SwingLabelHook) hook;
		tmp.setGs(this);
		this.setLabelUpdater(tmp);
	}

}
