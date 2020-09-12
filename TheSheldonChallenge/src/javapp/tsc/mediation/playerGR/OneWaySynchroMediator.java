package javapp.tsc.mediation.playerGR;

public final class OneWaySynchroMediator extends PlayerRoundMediator {

	@Override
	public synchronized void notifyGameRound() {
		this.increment();
		this.notifyAll();
	}

	@Override
	public synchronized void notifyPlayers() {
		while (!this.isCounterMax()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.reset();
		this.notifyAll();
	}

	@Override
	public synchronized void waitForGameRound() {
		this.notifyAll();
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void waitForPlayers() {
		while (!allPlayersChose(this.getP1(), this.getP2())) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
