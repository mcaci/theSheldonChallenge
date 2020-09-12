package core.tsc.mechanics.gameSession.classic;

import core.tsc.ipc.IHook;
import core.tsc.player.impl.afc.RandomPlayer;

public abstract class AutomaticGameGS extends RoundBasedGS {

	protected AutomaticGameGS(RandomPlayer p1, RandomPlayer p2) {
		super(p1, p2);
	}

	protected AutomaticGameGS(RandomPlayer p1, RandomPlayer p2, int winScore) {
		super(p1, p2, winScore);
	}

	@Override
	protected abstract void registerToHook(IHook hook);
}
