/**
 * 
 */
package javapp.tsc.GUI.components.button.fullSize;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.lang.vocab.MainMenuButtonLabel;

/**
 * @author nikiforos
 * 
 */
public final class RulesButton extends MainMenuButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3249105949295180299L;

	/**
	 * @param container
	 * @param label
	 */
	public RulesButton(BasePanel container) {
		super(container, MainMenuButtonLabel.RULES);
	}

}
