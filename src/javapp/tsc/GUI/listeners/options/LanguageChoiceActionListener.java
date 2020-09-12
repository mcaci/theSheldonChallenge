/**
 * 
 */
package javapp.tsc.GUI.listeners.options;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.panels.OptionsPanel;

/**
 * @author nikiforos
 * 
 */
public final class LanguageChoiceActionListener extends OptionPanelItemListener {

	/**
	 * @param optionsWindow
	 */
	public LanguageChoiceActionListener(final OptionsPanel self) {
		super(self, self.getPanelState());
	}

	@Override
	public final void actionPerformed(final ActionEvent arg0) {
		super.actionPerformed(arg0);
		printChange();
	}
	
	// TODO: just for debug
	private final void printChange(){
		final OptionsPanel op = (OptionsPanel) previousPanel;
		System.out.println(op.getLangComboBox().getSelectedItem().toString());
	}

}
