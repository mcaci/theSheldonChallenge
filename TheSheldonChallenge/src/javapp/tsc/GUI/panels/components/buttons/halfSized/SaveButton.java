/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons.halfSized;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.HalfSizedButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.OptionMenuLabel;
import core.tsc.AppCore;

/**
 * @author nikiforos
 * 
 */
public final class SaveButton extends HalfSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4408958630864877107L;

	/**
	 * @param container
	 */
	public SaveButton(BasePanel container) {
		super(container, new XMLFileTranslator().translate(
				OptionMenuLabel.SAVE_BUTTON, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
