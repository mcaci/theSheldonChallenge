package core.tsc.lang.vocab;

import core.tsc.lang.Translatable;

/**
 * Different labels for the different main menu button
 * 
 * @author nikiforos
 * 
 */
public enum MainMenuButtonLabel implements Translatable {
	NEW_GAME, OPTIONS, RULES, CREDITS;

	@Override
	public final String getXMLPath() {
		return "//buttonset/mainmenu/" + this.name().toLowerCase() + "/";
	}
}
