package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.components.ruleHelp.RuleHelpPanel;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.panels.base.TitledQuittablePanel;

public final class RuleInfoPanel extends TitledQuittablePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7700839909197110805L;
	private RuleHelpPanel rulePanel;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public RuleInfoPanel(TSCWindow frame) {
		super(frame);
	}

	@Override
	protected final void initGUI(TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.RULES);

		// final Language currentLang =
		// AppCore.getInstance().getGSData().getCurrentLanguage();
		try {
			FlowLayout middlePanelLayout = new FlowLayout();
			this.getMiddlePanel().setLayout(middlePanelLayout);

			{
				{
					rulePanel = new RuleHelpPanel();
					this.getMiddlePanel().add(rulePanel);
				}
				{
					// getBack().setText(new
					// XMLFileTranslator().translate(BackButtonLabel.BACK,
					// currentLang));
					// getBack().addActionListener(new
					// PanelStateTransitionListener(this,
					// PanelState.MAIN_MENU));
				}
			}
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
