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
