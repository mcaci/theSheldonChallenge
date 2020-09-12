package javapp.tsc.lang.vocab;

import core.tsc.lang.Translatable;

/**
 * Different labels for the back button
 * 
 * @author nikiforos
 * 
 */
public enum BackButtonLabel implements Translatable {
	BACK, CANCEL, MAIN_MENU, QUIT;

	@Override
	public String getXMLPath() {
		return "//buttonset/back_set/" + this.name().toLowerCase() + "/";
	}
}
