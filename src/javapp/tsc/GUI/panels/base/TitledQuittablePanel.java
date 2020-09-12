package javapp.tsc.GUI.panels.base;

import java.awt.BorderLayout;

import javapp.tsc.GUI.components.button.fullSize.BackButton;
import javapp.tsc.GUI.frames.TSCWindow;
import core.tsc.lang.vocab.BackButtonLabel;

public abstract class TitledQuittablePanel extends TitledPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3991913930629150809L;

	private BackButton back;

	public TitledQuittablePanel(final TSCWindow frame) {
		super(frame);
	}

	protected void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		try {
			this.setPreferredSize(new java.awt.Dimension(200, 300));
			{
				back = new BackButton(this, BackButtonLabel.BACK);
				this.add(back, BorderLayout.SOUTH);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the back
	 */
	protected final BackButton getBack() {
		return back;
	}

	/**
	 * @param back
	 *            the back to set
	 */
	protected final void setBack(final BackButton back) {
		this.back = back;
	}

}
