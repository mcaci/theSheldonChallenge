/**
 * 
 */
package javapp.tsc.GUI.components.fullSizeButton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.lang.vocab.GameRelatedButtonLabel;

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
