/**
 * 
 */
package javapp.tsc.GUI.components.halfSizebutton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLFileTranslator;
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
		super(container, new XMLFileTranslator().translate(
				GameRelatedButtonLabel.RANDOM, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
