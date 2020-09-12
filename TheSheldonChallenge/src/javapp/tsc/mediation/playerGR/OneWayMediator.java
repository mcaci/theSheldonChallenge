package javapp.tsc.mediation.playerGR;

@Deprecated
public final class OneWayMediator extends PlayerRoundMediatorOLD {

	@Override
	public void notifyGameRound() {
		if (this.isCounterMax()) {
			this.reset();
		}
	}

	// irrelevant here: player "dies" after choosing
	@Override
	public void notifyPlayers() {
	}

	/**
	 * not a really a wait (GameRound already asked Players to go at this point)
	 */
	@Override
	public void waitForGameRound() {
		this.increment();
	}

	@Override
	public void waitForPlayers() {
		while (!allPlayersChose(this.getP1(), this.getP2())) {
			// TODO: to remove
			System.out.print("-");
		}
		while (this.isCounterZero())
			;
	}

}
