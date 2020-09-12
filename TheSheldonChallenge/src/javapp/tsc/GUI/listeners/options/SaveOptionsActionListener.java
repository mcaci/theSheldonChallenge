package javapp.tsc.GUI.listeners.options;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.OptionsPanel;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.rule.Rule;

public final class SaveOptionsActionListener extends
		PanelStateTransitionListener {

	private OptionsPanel ow;

	public SaveOptionsActionListener(OptionsPanel self) {
		super(self, self.getPanelState().backPanel());
		ow = self;
	}

	@Override
	public final void actionPerformed(ActionEvent arg0) {

		// TODO: introduce method to check if some particular option was
		// modified

		// set lang
		Language newLang = Language.valueOf(ow.getLangComboBox()
				.getSelectedItem().toString());

		// set maxScore
		int newMaxScore = 0;
		try {
			newMaxScore = Integer.valueOf(ow.getScoreTextArea().getText());
		} catch (NumberFormatException e) {
			// TODO: use window pane and particular exception for it
			System.out.println("Input value has a bad format: \""
					+ ow.getScoreTextArea().getText() + "\"");
			System.out
					.println("Please write a number for the \"score to win\" area.");
			return;
		}
		// set rule
		Rule newRule = Rule.valueOf(ow.getRulesComboBox().getSelectedItem()
				.toString());

		AppCore.getInstance().getData()
				.setOptionData(newLang, newMaxScore, newRule);

		// checkout (TODO: not useful in the future)
		checkout();

		super.actionPerformed(arg0);
	}

	private static final void checkout() {
		System.out.println(AppCore.getInstance().getData().toString());
		System.out.println("Options are saved");
	}

}
