/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons.fullSized;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.FullSizedButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.PlayerButtonLabel;
import core.tsc.AppCore;

/**
 * @author nikiforos
 * 
 */
abstract class PlayerButton extends FullSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2715026828593257087L;

	/**
	 * @param container
	 * @param name
	 */
	public PlayerButton(BasePanel container, PlayerButtonLabel label) {
		super(container, new XMLFileTranslator().translate(label, AppCore
				.getInstance().getSessionLanguage()));
	}

}
