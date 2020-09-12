package javapp.tsc.mechanics.gameSession;

import javapp.tsc.ipc.com.SwingLabelHook;
import core.tsc.ipc.IGameHook;
import core.tsc.mechanics.gameSession.classic.AutomaticGameGS;
import core.tsc.player.impl.afc.RandomPlayer;

public final class RB_Auto_GS extends AutomaticGameGS {

	public RB_Auto_GS(RandomPlayer p1, RandomPlayer p2) {
		super(p1, p2);
	}
	
	public RB_Auto_GS(RandomPlayer p1, RandomPlayer p2, int winScore) {
		super(p1, p2, winScore);
	}

	@Override
	protected void registerToHook(IGameHook hook) {
		SwingLabelHook tmp = (SwingLabelHook) hook;
		tmp.setGs(this);
		this.setLabelUpdater(tmp);
		tmp = null;
	}

}
