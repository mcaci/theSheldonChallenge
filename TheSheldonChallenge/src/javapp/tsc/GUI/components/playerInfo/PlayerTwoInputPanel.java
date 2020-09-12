package javapp.tsc.GUI.components.playerInfo;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.player.util.TwoPlayerNameSet;

public final class PlayerTwoInputPanel extends PlayerPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5489192391418031597L;

	public PlayerTwoInputPanel(BasePanel container, int width, int height) {
		super(container, width, height);
		this.playerName = AppCore.getInstance().getNameP2();
		this.defaultPlayerName = TwoPlayerNameSet.PLAYER2.name();
		this.buildInputPlayerInfo();
	}

}