package javapp.tsc.GUI.panels.base;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public final class NotReadyPanel extends TitledQuittablePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2245835962039807469L;

	private JLabel messageLabel;

	public NotReadyPanel(TSCWindow frame) {
		super(frame);
	}

	@Override
	protected final void initGUI(TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.NOT_READY);
		try {
			BorderLayout middlePanelLayout = new BorderLayout();
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				this.getBack().addActionListener(
						new PanelStateTransitionListener(this, this
								.getPanelState().backPanel()));
			}
			{
				messageLabel = new JLabel();
				this.getMiddlePanel().add(messageLabel, BorderLayout.CENTER);
				messageLabel.setText("Soon to be released");
				messageLabel.setPreferredSize(new Dimension(179, 20));
				messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
