/**
 * 
 */
package javapp.tsc.GUI.components.button.fullSize;

import javapp.tsc.GUI.panels.base.BasePanel;
import core.tsc.AppCore;
import core.tsc.lang.translator.XMLTranslator;
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
		super(container, new XMLTranslator().translate(label, AppCore
				.getInstance().getSessionLanguage()));
	}

}
