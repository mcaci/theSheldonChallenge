/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons.fullSized;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.FullSizedButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.GameRelatedButtonLabel;
import core.tsc.AppCore;

/**
 * @author nikiforos
 * 
 */
public final class RematchButton extends FullSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3080925228064129231L;

	/**
	 * @param container
	 */
	public RematchButton(BasePanel container) {
		super(container, new XMLFileTranslator().translate(
				GameRelatedButtonLabel.REMATCH, AppCore.getInstance()
						.getSessionLanguage()));
	}

}
