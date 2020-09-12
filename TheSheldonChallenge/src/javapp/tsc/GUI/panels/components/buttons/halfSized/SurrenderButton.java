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
public final class SurrenderButton extends HalfSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -502778490604355957L;

	/**
	 * @param container
	 */
	public SurrenderButton(BasePanel container) {
		super(container, new XMLFileTranslator().translate(
				GameRelatedButtonLabel.SURRENDER, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
