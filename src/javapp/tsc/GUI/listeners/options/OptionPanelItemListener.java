package javapp.tsc.GUI.listeners.options;

import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.OptionsPanel;
import javapp.tsc.GUI.panels.state.PanelState;

abstract class OptionPanelItemListener extends PanelStateTransitionListener {

	public OptionPanelItemListener(final OptionsPanel prevPanel, final PanelState nextPanelState) {
		super(prevPanel, nextPanelState);
	}

}
