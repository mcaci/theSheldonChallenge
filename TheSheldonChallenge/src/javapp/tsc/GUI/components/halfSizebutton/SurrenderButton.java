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
