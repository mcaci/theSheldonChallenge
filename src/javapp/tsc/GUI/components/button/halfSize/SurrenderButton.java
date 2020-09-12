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
public final class SurrenderButton extends HalfSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -502778490604355957L;

	/**
	 * @param container
	 */
	public SurrenderButton(BasePanel container) {
		super(container, new XMLTranslator().translate(
				GameRelatedButtonLabel.SURRENDER, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
