package javapp.tsc.mediation.playerGUI;

public final class OneWaySynchroMediator extends PlayerGUIMediator {

	@Override
	public synchronized final void updateWaitForMove() {
		while (isWaitingForChoice()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setWaitingForChoice(true);
	}

	@Override
	public synchronized void notifyPlayer() {
		this.setWaitingForChoice(false);
		this.notify();
	}

}
