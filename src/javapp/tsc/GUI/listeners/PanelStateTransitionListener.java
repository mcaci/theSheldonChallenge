package javapp.tsc.GUI.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.state.PanelState;

public class PanelStateTransitionListener implements ActionListener {

	private final PanelState previous;
	private final PanelState next;
	protected BasePanel previousPanel;
	protected BasePanel nextPanel;

	public PanelStateTransitionListener(
			final BasePanel prevPanel,
			final PanelState nextPanelState) {
		previousPanel = prevPanel;
		nextPanel = null;

		previous = prevPanel.getPanelState();
		next = nextPanelState;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		final boolean isTransitioning = isRealTransition();
		this.showTransitionStatus(isTransitioning);
		if (isTransitioning) {
			this.nextPanel = next.buildPanel(GUICore.getInstance().getTSCW());
			GUICore.getInstance().getTSCW().getContentPane().add(nextPanel);
			this.previousPanel.setVisible(false);
			this.nextPanel.setVisible(true);
		}
	}

	private final boolean isRealTransition() {
		return !(this.previous.equals(this.next));
	}

	private final void showTransitionStatus(final boolean transitioning) {
		if (transitioning) {
			System.out.println("Going from " + this.previous.name() + " to " + this.next.name());
		} else {
			System.out.println(this.previous.name() + " " + this.next.name());
			System.out.println("No transition");
		}
	}

}
