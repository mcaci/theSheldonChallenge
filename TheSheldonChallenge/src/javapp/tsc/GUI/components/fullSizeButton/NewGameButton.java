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
public final class NewGameButton extends MainMenuButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2386322745554831682L;

	/**
	 * @param container
	 */
	public NewGameButton(BasePanel container) {
		super(container, MainMenuButtonLabel.NEW_GAME);
	}

}
