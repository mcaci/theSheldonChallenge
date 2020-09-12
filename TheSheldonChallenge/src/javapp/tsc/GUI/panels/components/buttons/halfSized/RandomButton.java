/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons.halfSized;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.HalfSizedButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.GameRelatedButtonLabel;
import core.tsc.AppCore;

/**
 * @author nikiforos
 * 
 */
public final class RandomButton extends HalfSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4801360111943616535L;

	/**
	 * @param container
	 * @param name
	 */
	public RandomButton(BasePanel container) {
		super(container, new XMLFileTranslator().translate(
				GameRelatedButtonLabel.RANDOM, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
