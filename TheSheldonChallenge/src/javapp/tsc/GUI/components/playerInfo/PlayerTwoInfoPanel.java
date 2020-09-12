package javapp.tsc.GUI.components.playerInfo;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;

public final class PlayerTwoInfoPanel extends PlayerPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6662513007450351180L;

	public PlayerTwoInfoPanel(BasePanel container, int width, int height) {
		super(container, width, height);
		this.playerName = AppCore.getInstance().getNameP2();
		this.buildInGameInfo();
	}
}
