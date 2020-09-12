/**
 * 
 */
package javapp.tsc.GUI.listeners.newgame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.NewGamePanel;
import javapp.tsc.ipc.com.SwingLabelHook;
import core.tsc.ipc.IntercomCore;

/**
 * @author nikiforos
 * 
 */
public final class GameTypeActionListener extends
		PanelStateTransitionListener {

	private int numberOfHumPlayers;

	public GameTypeActionListener(NewGamePanel self, int num) {
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
		setHooks(arg0, numberOfHumPlayers);

		System.out.println(numberOfHumPlayers);
		super.actionPerformed(arg0);
	}

	// TODO: incomplete
	private void setHooks(ActionEvent arg0, int numberOfHumPlayers) {
		switch (numberOfHumPlayers) {
		case 0:
			break;
		case 1:
			IntercomCore.getInstance().setHook(new SwingLabelHook());
			break;
		case 2:
			break;
		default:
			break;
		}
	}
}
