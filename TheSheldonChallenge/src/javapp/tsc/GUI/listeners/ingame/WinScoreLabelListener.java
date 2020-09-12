package javapp.tsc.GUI.listeners.ingame;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javapp.tsc.GUI.components.playerInfo.PlayerPanel;
import core.tsc.AppCore;

/**
 * TODO: to inspect
 * 
 * @author nikiforos
 * 
 */
public final class WinScoreLabelListener implements PropertyChangeListener {

	private PlayerPanel pp;

	public WinScoreLabelListener(PlayerPanel playerPanel) {
		this.pp = playerPanel;
	}

	@Override
	public final void propertyChange(PropertyChangeEvent arg0) {
		if (pp.getScoreLabel()
				.getText()
				.equals(Integer.toString(AppCore.getInstance().getScoreToWin()))) {
			pp.setGameOver(true);
		}

	}

}
