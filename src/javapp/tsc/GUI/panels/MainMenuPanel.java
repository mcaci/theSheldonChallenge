package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.components.button.fullSize.BackButton;
import javapp.tsc.GUI.components.button.fullSize.CreditsButton;
import javapp.tsc.GUI.components.button.fullSize.NewGameButton;
import javapp.tsc.GUI.components.button.fullSize.OptionsButton;
import javapp.tsc.GUI.components.button.fullSize.RulesButton;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.ExitGameListener;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.base.FillerPanel;
import javapp.tsc.GUI.panels.base.TitledPanel;
import javapp.tsc.GUI.panels.state.PanelState;
import core.tsc.lang.vocab.BackButtonLabel;

public final class MainMenuPanel extends TitledPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1598755560762778456L;

	public MainMenuPanel(final TSCWindow frame) {
		super(frame);
	}

	protected final void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.MAIN_MENU);
		try {
			final FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0,
					2);
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				final FillerPanel filler = new FillerPanel(7);
				this.getMiddlePanel().add(filler);
			}
			{
				final NewGameButton ngb = new NewGameButton(this);
				this.getMiddlePanel().add(ngb);
				ngb.addActionListener(new PanelStateTransitionListener(this,
						PanelState.NEW_GAME));
			}
			{
				final OptionsButton ob = new OptionsButton(this);
				this.getMiddlePanel().add(ob);
				ob.addActionListener(new PanelStateTransitionListener(this,
						PanelState.OPTIONS));
			}
			{
				final RulesButton rb = new RulesButton(this);
				this.getMiddlePanel().add(rb);
				rb.addActionListener(new PanelStateTransitionListener(this,
						PanelState.RULES));
			}
			{
				final CreditsButton cb = new CreditsButton(this);
				this.getMiddlePanel().add(cb);
				cb.addActionListener(new PanelStateTransitionListener(this,
						PanelState.CREDITS));
			}
			{
				final BackButton backButton = new BackButton(this,
						BackButtonLabel.QUIT);
				this.getMiddlePanel().add(backButton);
				backButton.addActionListener(new ExitGameListener());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
