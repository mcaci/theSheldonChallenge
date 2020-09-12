/**
 * 
 */
package javapp.tsc.GUI.components.button.fullSize;

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
	private static final int N_HUMAN_PLAYER = 2;
	
	/**
	 * @param container
	 */
	public TwoPlayersButton(BasePanel container) {
		super(container, PlayerButtonLabel.TWO_PLAYERS, N_HUMAN_PLAYER);
	}

}
