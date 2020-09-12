/**
 * 
 */
package javapp.tsc.GUI.components.fullSizeButton;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.lang.vocab.MainMenuButtonLabel;

/**
 * @author nikiforos
 * 
 */
abstract class MainMenuButton extends FullSizedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6251849937522766089L;

	/**
	 * @param container
	 * @param name
	 */
	public MainMenuButton(BasePanel container, MainMenuButtonLabel label) {
		super(container, new XMLFileTranslator().translate(label, AppCore
				.getInstance().getSessionLanguage()));
	}

}
