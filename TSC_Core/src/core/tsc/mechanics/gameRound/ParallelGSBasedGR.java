package core.tsc.mechanics.gameRound;

import core.tsc.ipc.synchronization.PlayerChoiceSynchronizer;
import core.tsc.mechanics.gameSession.classic.RoundBasedGS;
import core.tsc.player.IPlayer;

public final class ParallelGSBasedGR extends GSBasedRound {

	public ParallelGSBasedGR(RoundBasedGS info) {
		super(info);
	}

	protected final boolean promptMoves(IPlayer p1, IPlayer p2) {
		PlayerChoiceSynchronizer pcs = new PlayerChoiceSynchronizer();
		p1.setNotifier(pcs);
		new Thread(p1, p1.getName()).start();
		pcs.holdIt();
		
		p2.setNotifier(pcs);
		new Thread(p2, p2.getName()).start();
		pcs.holdIt();
		
		pcs = null;
		return true;
	}

}
