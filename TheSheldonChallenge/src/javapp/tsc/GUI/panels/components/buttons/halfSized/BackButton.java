/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons.halfSized;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.HalfSizedButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.BackButtonLabel;
import core.tsc.AppCore;

/**
 * @author nikiforos
 * 
 */
public final class BackButton extends HalfSizedButton {

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
