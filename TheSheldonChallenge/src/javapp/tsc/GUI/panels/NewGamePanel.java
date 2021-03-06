package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.components.fullSizeButton.OnePlayerButton;
import javapp.tsc.GUI.components.fullSizeButton.TwoPlayersButton;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.listeners.newgame.GameTypeActionListener;
import javapp.tsc.GUI.panels.base.FillerPanel;
import javapp.tsc.GUI.panels.base.TitledQuittablePanel;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.lang.vocab.BackButtonLabel;

public final class NewGamePanel extends TitledQuittablePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4714533440507751267L;
	private OnePlayerButton onePl;
	private TwoPlayersButton twoPl;

	public NewGamePanel(TSCWindow frame) {
		super(frame);
	}

	protected final void initGUI(TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.NEW_GAME);
		try {
			// this.setPreferredSize(new java.awt.Dimension(240, 320));
			Language currentLang = AppCore.getInstance().getSessionLanguage();
			{
				FlowLayout middlePanelLayout = new FlowLayout(
						FlowLayout.CENTER, 0, 2);
				this.getMiddlePanel().setLayout(middlePanelLayout);
				{
					FillerPanel filler = new FillerPanel(7);
					this.getMiddlePanel().add(filler);
				}
				{
					onePl = new OnePlayerButton(this);
					this.getMiddlePanel().add(onePl);
					onePl.addActionListener(new GameTypeActionListener(
							this, 1));

				}
				{
					twoPl = new TwoPlayersButton(this);
					this.getMiddlePanel().add(twoPl);
					twoPl.addActionListener(new GameTypeActionListener(
							this, 2));
					// TODO: remove it
					twoPl.setVisible(false);
				}
				{
					this.getBack().setText(
							new XMLFileTranslator().translate(
									BackButtonLabel.BACK, currentLang));
					this.getBack().addActionListener(
							new PanelStateTransitionListener(this,
									PanelState.MAIN_MENU));
				}
			}
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
