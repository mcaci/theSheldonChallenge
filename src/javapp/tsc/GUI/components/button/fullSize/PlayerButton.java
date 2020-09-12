/**
 * 
 */
package javapp.tsc.GUI.components.button.fullSize;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.PlayerButtonLabel;

/**
 * @author nikiforos
 * 
 */
public abstract class PlayerButton extends FullSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2715026828593257087L;
	
	/**
	 * @param container
	 * @param name
	 */
	public PlayerButton(BasePanel container, PlayerButtonLabel label, int number_of_hum_players) {
		super(container, new XMLTranslator().translate(label, AppCore
				.getInstance().getSessionLanguage()));
	}

}
