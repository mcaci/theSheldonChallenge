/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons.fullSized;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.FullSizedButton;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.MainMenuButtonLabel;
import core.tsc.AppCore;

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
