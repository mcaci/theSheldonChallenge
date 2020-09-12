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
public final class ZeroPlayerButton extends PlayerButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4066955514190909483L;
	private static final int N_HUMAN_PLAYER = 0;
	
	/**
	 * @param container
	 * @param label
	 */
	public ZeroPlayerButton(BasePanel container) {
		super(container, PlayerButtonLabel.AI_VS_AI, N_HUMAN_PLAYER);
	}

}
