/**
 * 
 */
package javapp.tsc.GUI.listeners.options;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.OptionsPanel;

/**
 * @author nikiforos
 * 
 */
public final class LanguageChoiceActionListener extends
		PanelStateTransitionListener {

	/**
	 * @param optionsWindow
	 */
	public LanguageChoiceActionListener(OptionsPanel self) {
		super(self, self.getPanelState());
	}

	@Override
	public final void actionPerformed(ActionEvent arg0) {
		OptionsPanel op = (OptionsPanel) previousPanel;
		System.out.println(op.getLangComboBox().getSelectedItem().toString());

		super.actionPerformed(arg0);
	}

}
