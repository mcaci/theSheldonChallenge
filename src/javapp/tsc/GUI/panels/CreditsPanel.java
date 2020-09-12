package javapp.tsc.GUI.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.components.button.fullSize.BackButton;
import javapp.tsc.GUI.components.extras.ImagePanel;
import javapp.tsc.GUI.components.extras.ScrollableTextArea;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.base.TitledPanel;
import javapp.tsc.GUI.panels.state.PanelState;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.BackButtonLabel;
import core.tsc.lang.vocab.OtherMessage;
import core.tsc.util.PathManager;

public final class CreditsPanel extends TitledPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2279974469699072619L;
	private ImagePanel smilePanel;
	private static final int SMILE_PANEL_SIZE = 100;
	private ScrollableTextArea creditsArea;

	public CreditsPanel(final TSCWindow frame) {
		super(frame);
	}

	@Override
	protected final void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.CREDITS);
		try {
			// this.setPreferredSize(new java.awt.Dimension(240, 320));
			final FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0, 4);
			this.getMiddlePanel().setLayout(middlePanelLayout);

			final Language currentLang = AppCore.getInstance().getSessionLanguage();
			{
				{
					final Dimension dim = new Dimension(SMILE_PANEL_SIZE,
							SMILE_PANEL_SIZE);
					final Point pos = new Point(41, 51);
					smilePanel = new ImagePanel(dim, pos, false);
					final String pathImage = PathManager.getFullDir(new String[] {
							PathManager.getCurrentPath(), "src", "javapp",
							"tsc", "img" })
							+ "me.jpg";
					smilePanel.draw(pathImage);
					this.getMiddlePanel().add(smilePanel);
					smilePanel.setPreferredSize(new java.awt.Dimension(dim));
				}
				{
					final Dimension dim = new Dimension(184, 67);
					final Point pos = new Point(5, 156);
					final String text = new XMLTranslator().translate(
							OtherMessage.CREDITS, currentLang)
							+ " "
							+ AppCore.MAIL_ADDRESS;
					creditsArea = new ScrollableTextArea(dim, pos, text);
					this.getMiddlePanel().add(creditsArea);
					creditsArea.setPreferredSize(dim);
				}
				{
					final BackButton backButton = new BackButton(this,
							BackButtonLabel.BACK);
					this.getMiddlePanel().add(backButton);
					backButton.addActionListener(new PanelStateTransitionListener(
									this, this.getPanelState().backPanel()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
