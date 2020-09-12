/**
 * 
 */
package javapp.tsc.GUI.components.fullSizeButton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.lang.vocab.PlayerButtonLabel;

/**
 * @author nikiforos
 * 
 */
public final class OnePlayerButton extends PlayerButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4066955514190909483L;

	/**
	 * @param container
	 * @param label
	 */
	public OnePlayerButton(BasePanel container) {
		super(container, PlayerButtonLabel.ONE_PLAYER);
	}

}
