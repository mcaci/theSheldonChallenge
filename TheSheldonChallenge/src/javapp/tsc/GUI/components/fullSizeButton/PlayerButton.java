/**
 * 
 */
package javapp.tsc.GUI.components.fullSizeButton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.lang.vocab.PlayerButtonLabel;

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
