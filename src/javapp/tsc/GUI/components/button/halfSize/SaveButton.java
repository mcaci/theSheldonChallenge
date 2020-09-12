/**
 * 
 */
package javapp.tsc.GUI.components.button.halfSize;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.OptionMenuLabel;

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
		super(container, new XMLTranslator().translate(
				OptionMenuLabel.SAVE_BUTTON, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
