package javapp.tsc.GUI.components.playerPanel;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;

public final class PlayerOneInfoPanel extends PlayerPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6662513007450351180L;

	public PlayerOneInfoPanel(BasePanel container, int width, int height) {
		super(container, width, height);
		this.playerName = AppCore.getInstance().getNameP1();
		this.buildInGameInfo();
	}

}
