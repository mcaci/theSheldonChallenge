package javapp.tsc.mediation.playerGUI;

public final class OneWayMediator extends PlayerGUIMediator {

	@Override
	public final void updateWaitForMove() {
		while (isWaitingForChoice()) {
			// TODO: remove it
			System.out.print(".");
		}
		this.setWaitingForChoice(true);
	}

	@Override
	public void notifyPlayer() {
		this.setWaitingForChoice(true);
	}

}
