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
public final class GoButton extends HalfSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1616657458221478859L;

	/**
	 * @param container
	 */
	public GoButton(BasePanel container) {
		super(container, new XMLTranslator().translate(
				GameRelatedButtonLabel.START, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
