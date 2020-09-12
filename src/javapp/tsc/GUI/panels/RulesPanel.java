package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.components.ruleHelp.RuleHelpPanel;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.base.TitledQuittablePanel;
import javapp.tsc.GUI.panels.state.PanelState;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.BackButtonLabel;

public final class RulesPanel extends TitledQuittablePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7700839909197110805L;
	private RuleHelpPanel rulePanel;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public RulesPanel(final TSCWindow frame) {
		super(frame);
	}

	@Override
	protected final void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.RULES);

		final Language currentLang = AppCore.getInstance().getSessionLanguage();
		try {
			final FlowLayout middlePanelLayout = new FlowLayout();
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				{
					rulePanel = new RuleHelpPanel();
					this.getMiddlePanel().add(rulePanel);
				}
				{
					getBack().setText(
							new XMLTranslator().translate(
									BackButtonLabel.BACK, currentLang));
					getBack().addActionListener(
							new PanelStateTransitionListener(this,
									PanelState.MAIN_MENU));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
