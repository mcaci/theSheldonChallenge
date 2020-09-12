package javapp.tsc.GUI.listeners.ingame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.components.button.halfSize.RandomButton;
import javapp.tsc.GUI.components.button.halfSize.SurrenderButton;
import javapp.tsc.GUI.components.chooser.IChooserButton;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.GUI.panels.state.PanelState;
import core.tsc.AppCore;
import core.tsc.player.impl.DummyPlayer;
import core.tsc.rule.ruleSet.IRuleSet;

public final class PlayerMoveListener extends PanelStateTransitionListener {

	public PlayerMoveListener(final InGamePanel self) {
		super(self, self.getPanelState());
	}

	public PlayerMoveListener(final InGamePanel self, final PanelState next) {
		super(self, next);
	}

	/**
	 * TODO: works only with one player
	 */
	@Override
	public synchronized final void actionPerformed(final ActionEvent arg0) {

		final InGamePanel igp = (InGamePanel) previousPanel;

		super.actionPerformed(arg0);

		IRuleSet move = null;
		if (arg0.getSource() instanceof IChooserButton) {
			move = ((IChooserButton) (arg0.getSource()))
					.getCorrespondingMove();
			igp.setMoveToReturn(move);
		} else if (arg0.getSource() instanceof RandomButton) {
			move = DummyPlayer.chooseRandomMove(AppCore.getInstance()
					.getSessionRule());
			igp.setMoveToReturn(move);
		} else if (arg0.getSource() instanceof SurrenderButton) {
			// the surrender mark (move = null)
			igp.setMoveToReturn(move);
		} else {
			// TODO: exception???
		}

		igp.getPlayerSynchronizer().resume();
	}

}