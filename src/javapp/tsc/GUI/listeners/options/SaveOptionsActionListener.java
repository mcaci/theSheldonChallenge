package javapp.tsc.GUI.listeners.options;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.panels.OptionsPanel;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.rule.Rule;
import core.tsc.util.Support;

public final class SaveOptionsActionListener extends OptionPanelItemListener {

	public SaveOptionsActionListener(final OptionsPanel self) {
		super(self, self.getPanelState().backPanel());
	}

	@Override
	public final void actionPerformed(final ActionEvent arg0) {

		final OptionsPanel ow = (OptionsPanel) this.previousPanel;
		
		// TODO: introduce method to check if some particular option was
		// modified

		// set lang
		final Language newLang = Language.parseString(ow.getLangComboBox().getSelectedItem().toString());

		// set maxScore
		int newMaxScore = 0;
		try {
			newMaxScore = Support.parseStringMaxScore(ow.getScoreTextArea().getText());
		} catch (NumberFormatException e) {
			// TODO: use window pane and particular exception for it
			System.out.println("Input value has a bad format: \"" + ow.getScoreTextArea().getText() + "\"");
			System.out.println("Please write a number for the \"score to win\" area.");
			return;
		}
		// set rule
		final Rule newRule = Rule.parseString(ow.getRulesComboBox().getSelectedItem().toString());

		// set data in core
		AppCore.getInstance().getData().setOptionData(newLang, newMaxScore, newRule);

		// checkout (TODO: not useful in the future)
		checkout();

		// if exception is found the window won't change because window change is the last event
		super.actionPerformed(arg0);
	}

	private static final void checkout() {
		System.out.println(AppCore.getInstance().getData().toString());
		System.out.println("Options are saved");
	}

}
