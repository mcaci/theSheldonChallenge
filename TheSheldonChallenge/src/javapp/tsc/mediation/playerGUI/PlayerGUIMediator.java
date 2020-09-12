package javapp.tsc.mediation.playerGUI;

import javapp.tsc.GUI.listeners.ingame.PlayerMoveListener;
import core.tsc.player.IPlayer;

public abstract class PlayerGUIMediator {

	private PlayerMoveListener listener;
	private IPlayer player;

	private boolean waitingForChoice;

	protected static final int MAX_COUNT = 2;

	public PlayerGUIMediator() {
		this.listener = null;
		this.player = null;
		this.setWaitingForChoice(true);
	}

	public abstract void updateWaitForMove();

	public abstract void notifyPlayer();

	public final void registerInGamePanel(PlayerMoveListener playerMoveListener) {
		this.listener = playerMoveListener;
	}

	public final void registerPlayer(IPlayer player) {
		this.player = player;
	}

	/**
	 * @return the panel
	 */
	@SuppressWarnings("unused")
	private final PlayerMoveListener getListener() {
		return listener;
	}

	/**
	 * @return the player
	 */
	@SuppressWarnings("unused")
	private final IPlayer getPlayer() {
		return player;
	}

	final void setWaitingForChoice(boolean waitingForChoice) {
		this.waitingForChoice = waitingForChoice;
	}

	final boolean isWaitingForChoice() {
		return waitingForChoice;
	}

}
