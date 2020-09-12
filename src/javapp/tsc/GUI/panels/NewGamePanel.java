package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.components.button.fullSize.OnePlayerButton;
import javapp.tsc.GUI.components.button.fullSize.TwoPlayersButton;
import javapp.tsc.GUI.components.button.fullSize.ZeroPlayerButton;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.listeners.newgame.GameTypeActionListener;
import javapp.tsc.GUI.panels.base.FillerPanel;
import javapp.tsc.GUI.panels.base.TitledQuittablePanel;
import javapp.tsc.GUI.panels.state.PanelState;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.BackButtonLabel;

public final class NewGamePanel extends TitledQuittablePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4714533440507751267L;
	private ZeroPlayerButton zeroPl;
	private OnePlayerButton onePl;
	private TwoPlayersButton twoPl;

	public NewGamePanel(final TSCWindow frame) {
		super(frame);
	}

	protected final void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.NEW_GAME);
		try {
			// this.setPreferredSize(new java.awt.Dimension(240, 320));
			final Language currentLang = AppCore.getInstance().getSessionLanguage();
			{
				final FlowLayout middlePanelLayout = new FlowLayout(
						FlowLayout.CENTER, 0, 2);
				this.getMiddlePanel().setLayout(middlePanelLayout);
				{
					final FillerPanel filler = new FillerPanel(7);
					this.getMiddlePanel().add(filler);
				}
				{
					zeroPl = new ZeroPlayerButton(this);
					this.getMiddlePanel().add(zeroPl);
					zeroPl.addActionListener(new GameTypeActionListener(this));
					zeroPl.setVisible(false); // TODO: remove it
				}
				{
					onePl = new OnePlayerButton(this);
					this.getMiddlePanel().add(onePl);
					onePl.addActionListener(new GameTypeActionListener(this));

				}
				{
					twoPl = new TwoPlayersButton(this);
					this.getMiddlePanel().add(twoPl);
					twoPl.addActionListener(new GameTypeActionListener(this));
				}
				{
					this.getBack().setText(
							new XMLTranslator().translate(
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
