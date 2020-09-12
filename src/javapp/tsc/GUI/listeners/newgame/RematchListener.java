package javapp.tsc.GUI.listeners.newgame;

import javapp.tsc.GUI.panels.EndGamePanel;
import javapp.tsc.GUI.panels.state.PanelState;

public final class RematchListener extends StartGameListener {

	public RematchListener(final EndGamePanel self) {
		super(self, PanelState.IN_GAME);
	}

}
