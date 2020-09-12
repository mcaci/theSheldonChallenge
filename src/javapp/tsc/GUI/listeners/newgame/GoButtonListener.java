/**
 * 
 */
package javapp.tsc.GUI.listeners.newgame;

import javapp.tsc.GUI.panels.InputPlayersPanel;
import javapp.tsc.GUI.panels.state.PanelState;

/**
 * @author nikiforos
 * 
 */
public final class GoButtonListener extends StartGameListener {

	/**
	 * 
	 */
	public GoButtonListener(InputPlayersPanel self) {
		super(self, PanelState.IN_GAME);
	}

}
