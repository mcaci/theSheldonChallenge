package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.components.fullSizeButton.BackButton;
import javapp.tsc.GUI.components.fullSizeButton.CreditsButton;
import javapp.tsc.GUI.components.fullSizeButton.NewGameButton;
import javapp.tsc.GUI.components.fullSizeButton.OptionsButton;
import javapp.tsc.GUI.components.fullSizeButton.RulesButton;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.base.FillerPanel;
import javapp.tsc.GUI.panels.base.TitledPanel;
import core.tsc.lang.vocab.BackButtonLabel;

public final class MainMenuPanel extends TitledPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1598755560762778456L;

	public MainMenuPanel(TSCWindow frame) {
		super(frame);
	}

	protected final void initGUI(TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.MAIN_MENU);
		try {
			FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0,
					2);
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				FillerPanel filler = new FillerPanel(7);
				this.getMiddlePanel().add(filler);
			}
			{
				NewGameButton ngb = new NewGameButton(this);
				this.getMiddlePanel().add(ngb);
				ngb.addActionListener(new PanelStateTransitionListener(this,
						PanelState.NEW_GAME));
			}
			{
				OptionsButton ob = new OptionsButton(this);
				this.getMiddlePanel().add(ob);
				ob.addActionListener(new PanelStateTransitionListener(this,
						PanelState.OPTIONS));
			}
			{
				RulesButton rb = new RulesButton(this);
				this.getMiddlePanel().add(rb);
				// rb.addActionListener(new PanelStateTransitionListener(this,
				// PanelState.RULES));
				rb.addActionListener(new PanelStateTransitionListener(this,
						PanelState.NOT_READY));
			}
			{
				CreditsButton cb = new CreditsButton(this);
				this.getMiddlePanel().add(cb);
				cb.addActionListener(new PanelStateTransitionListener(this,
						PanelState.CREDITS));
			}
			{
				BackButton backButton = new BackButton(this,
						BackButtonLabel.QUIT);
				this.getMiddlePanel().add(backButton);
				backButton.addActionListener(new PanelStateTransitionListener(
						this, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
