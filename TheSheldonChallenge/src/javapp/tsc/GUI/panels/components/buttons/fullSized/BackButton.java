/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons.fullSized;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.FullSizedButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.BackButtonLabel;
import core.tsc.AppCore;

/**
 * @author nikiforos
 * 
 */
public final class BackButton extends FullSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9841470864918429L;

	/**
	 * @param container
	 */
	public BackButton(BasePanel container, BackButtonLabel label) {
		super(container, new XMLFileTranslator().translate(label, AppCore
				.getInstance().getSessionLanguage()));
	}

}
