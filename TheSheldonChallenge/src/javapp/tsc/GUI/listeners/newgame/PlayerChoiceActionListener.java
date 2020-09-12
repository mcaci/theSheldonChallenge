/**
 * 
 */
package javapp.tsc.GUI.listeners.newgame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.NewGamePanel;

/**
 * @author nikiforos
 * 
 */
public final class PlayerChoiceActionListener extends
		PanelStateTransitionListener {

	private int numberOfHumPlayers;

	public PlayerChoiceActionListener(NewGamePanel self, int num) {
		super(self, PanelState.INPUT_PLAYERS);
		numberOfHumPlayers = num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public final void actionPerformed(ActionEvent arg0) {
		// TODO: incomplete
		switch (numberOfHumPlayers) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			break;
		}

		System.out.println(numberOfHumPlayers);
		super.actionPerformed(arg0);
	}

}
