package javapp.tsc.mediation.playerGR;

import javapp.tsc.gameRound.impl.regular.TwoPlayersRound;
import core.tsc.player.IPlayer;
import core.tsc.player.util.PlayerState;

public abstract class PlayerRoundMediatorOLD {

	private TwoPlayersRound round;
	private IPlayer p1;
	private IPlayer p2;

	private int busyCounter = 0;
	private static final int MAX_COUNT = 2;

	public PlayerRoundMediatorOLD() {
		this.round = null;
		this.p1 = null;
		this.p2 = null;
	}

	public abstract void waitForPlayers();

	public abstract void waitForGameRound();

	public abstract void notifyPlayers();

	public abstract void notifyGameRound();

	protected static final boolean allPlayersChose(IPlayer p1, IPlayer p2) {
		boolean flag = true;
		flag &= p1.checkIfPlayerStateIs(PlayerState.PERFORMED_MOVE);
		flag &= p2.checkIfPlayerStateIs(PlayerState.PERFORMED_MOVE);
		return flag;
	}

	public final void registerTwoPLGameRound(TwoPlayersRound gr) {
		this.round = gr;
		this.p1 = gr.getP1();
		this.p2 = gr.getP2();
	}

	final IPlayer getP1() {
		return this.p1;
	}

	final IPlayer getP2() {
		return this.p2;
	}

	final TwoPlayersRound getGr() {
		return this.round;
	}

	final synchronized void increment() {
		this.busyCounter++;
	}

	final synchronized void reset() {
		this.busyCounter = 0;
	}

	final synchronized boolean isCounterZero() {
		return this.checkCounter(0);
	}

	final synchronized boolean isCounterMax() {
		return this.checkCounter(MAX_COUNT);
	}

	private final synchronized boolean checkCounter(int count) {
		return this.busyCounter == count;
	}
}
