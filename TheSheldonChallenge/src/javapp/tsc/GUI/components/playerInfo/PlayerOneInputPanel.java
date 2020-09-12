package javapp.tsc.GUI.components.playerInfo;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.player.util.TwoPlayerNameSet;

public final class PlayerOneInputPanel extends PlayerPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5481049988352964925L;

	public PlayerOneInputPanel(BasePanel container, int width, int height) {
		super(container, width, height);
		this.playerName = AppCore.getInstance().getNameP1();
		this.defaultPlayerName = TwoPlayerNameSet.PLAYER1.name();
		this.buildInputPlayerInfo();
	}

}
