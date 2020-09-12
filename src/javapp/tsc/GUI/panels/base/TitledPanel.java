package javapp.tsc.GUI.panels.base;

import java.awt.BorderLayout;

import javapp.tsc.GUI.frames.TSCWindow;

public abstract class TitledPanel extends BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -78281735499385582L;

	private TitleLabel gameTitle;

	public TitledPanel(final TSCWindow frame) {
		super(frame);
	}

	protected void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		try {
			this.setPreferredSize(new java.awt.Dimension(200, 300));
			{
				gameTitle = new TitleLabel();
				this.add(gameTitle, BorderLayout.NORTH);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the gameTitle
	 */
	public final TitleLabel getGameTitle() {
		return gameTitle;
	}

	/**
	 * @param gameTitle
	 *            the gameTitle to set
	 */
	protected final void setGameTitle(final TitleLabel gameTitle) {
		this.gameTitle = gameTitle;
	}
}
