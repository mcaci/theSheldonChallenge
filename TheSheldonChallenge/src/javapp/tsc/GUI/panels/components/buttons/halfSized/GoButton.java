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
public final class GoButton extends HalfSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1616657458221478859L;

	/**
	 * @param container
	 */
	public GoButton(BasePanel container) {
		super(container, new XMLFileTranslator().translate(
				GameRelatedButtonLabel.START, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
