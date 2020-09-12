package javapp.tsc.GUI.listeners.ingame;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javapp.tsc.GUI.components.playerPanel.PlayerPanel;
import core.tsc.AppCore;

/**
 * TODO: to inspect
 * 
 * @author nikiforos
 * 
 */
public final class WinScoreLabelListener implements PropertyChangeListener {

	private PlayerPanel pp;

	public WinScoreLabelListener(final PlayerPanel playerPanel) {
		this.pp = playerPanel;
	}

	@Override
	public final void propertyChange(final PropertyChangeEvent arg0) {
		if (pp.getScoreLabel()
				.getText()
				.equals(Integer.toString(AppCore.getInstance().getScoreToWin()))) {
			// TODO: what to do here? sounds like useless
		}

	}

}
