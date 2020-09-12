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
public final class TwoPlayersButton extends PlayerButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8202455827017403832L;

	/**
	 * @param container
	 */
	public TwoPlayersButton(BasePanel container) {
		super(container, PlayerButtonLabel.TWO_PLAYERS);
	}

}
