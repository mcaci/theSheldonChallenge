package javapp.tsc.mechanics.gameSession.roundBased;

import javapp.tsc.ipc.com.SwingLabelHook;
import javapp.tsc.player.impl.human.SwingPlayer;
import core.tsc.ipc.IHook;
import core.tsc.mechanics.gameSession.classic.RoundBasedGS;
import core.tsc.player.impl.afc.RandomPlayer;

public final class RB_GUI_GS extends RoundBasedGS {

	/**
	 * Each concrete implementation of a GameSession needs to provide the two
	 * players and the ruleSet
	 */
	public RB_GUI_GS(SwingPlayer p1, RandomPlayer p2) {
		super(p1, p2);
	}

	/**
	 * Full constructor
	 */
	public RB_GUI_GS(SwingPlayer p1, RandomPlayer p2, int winScore) {
		super(p1, p2, winScore);
	}
	
	@Override
	protected void registerToHook(IHook hook){
		SwingLabelHook tmp = (SwingLabelHook) hook;
		tmp.setGs(this);
		this.setLabelUpdater(tmp);
	}

}
