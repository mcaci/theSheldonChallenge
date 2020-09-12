package javapp.tsc.GUI.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.base.TitledPanel;
import javapp.tsc.GUI.panels.components.ImagePanel;
import javapp.tsc.GUI.panels.components.ScrollableTextArea;
import javapp.tsc.GUI.panels.components.buttons.fullSized.BackButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.BackButtonLabel;
import javapp.tsc.lang.vocab.OtherMessage;
import core.tsc.AppCore;
import core.tsc.lang.Language;

public final class CreditsPanel extends TitledPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2279974469699072619L;
	private ImagePanel smilePanel;
	private static final int SMILE_PANEL_SIZE = 100;
	private ScrollableTextArea creditsArea;

	private static final String MAIL_ADDRESS = "\"thesheldonchallenge@gmail.com\"";

	public CreditsPanel(TSCWindow frame) {
		super(frame);
	}

	@Override
	protected final void initGUI(TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.CREDITS);
		try {
			// this.setPreferredSize(new java.awt.Dimension(240, 320));
			FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0,
					4);
			this.getMiddlePanel().setLayout(middlePanelLayout);

			Language currentLang = AppCore.getInstance().getSessionLanguage();
			{
				{
					final Dimension dim = new Dimension(SMILE_PANEL_SIZE,
							SMILE_PANEL_SIZE);
					final Point pos = new Point(41, 51);
					smilePanel = new ImagePanel(dim, pos, false);
					smilePanel.draw("./src/javapp/tsc/img/me.jpg");
					this.getMiddlePanel().add(smilePanel);
					smilePanel.setPreferredSize(new java.awt.Dimension(dim));
					// this.add(smilePanel);
				}
				{
					final Dimension dim = new Dimension(184, 67);
					final Point pos = new Point(5, 156);
					final String text = new XMLFileTranslator().translate(
							OtherMessage.CREDITS, currentLang)
							+ " "
							+ MAIL_ADDRESS;
					creditsArea = new ScrollableTextArea(dim, pos, text);
					// not implemented beacause ScrollableTextArea can be more
					// portable thing than the others
					this.getMiddlePanel().add(creditsArea);
					creditsArea.setPreferredSize(dim);
					// this.add(creditsArea);
				}
				{
					BackButton backButton = new BackButton(this,
							BackButtonLabel.BACK);
					this.getMiddlePanel().add(backButton);
					backButton
							.addActionListener(new PanelStateTransitionListener(
									this, this.getPanelState().backPanel()));
				}
			}
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
