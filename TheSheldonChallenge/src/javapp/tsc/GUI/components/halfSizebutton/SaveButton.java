/**
 * 
 */
package javapp.tsc.GUI.components.halfSizebutton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLFileTranslator;
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
		super(container, new XMLFileTranslator().translate(
				OptionMenuLabel.SAVE_BUTTON, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
