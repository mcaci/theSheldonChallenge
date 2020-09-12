/**
 * 
 */
package javapp.tsc.GUI.components.halfSizebutton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.lang.vocab.BackButtonLabel;

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
