/**
 * 
 */
package javapp.tsc.GUI.components.button.halfSize;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.GameRelatedButtonLabel;

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
		super(container, new XMLTranslator().translate(
				GameRelatedButtonLabel.RANDOM, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
