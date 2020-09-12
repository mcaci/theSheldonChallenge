/**
 * 
 */
package javapp.tsc.GUI.components.fullSizeButton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.lang.vocab.MainMenuButtonLabel;

/**
 * @author nikiforos
 * 
 */
public final class CreditsButton extends MainMenuButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8866444568206035323L;

	/**
	 * @param container
	 * @param label
	 */
	public CreditsButton(BasePanel container) {
		super(container, MainMenuButtonLabel.CREDITS);
	}

}
