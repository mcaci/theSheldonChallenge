package javapp.tsc.lang.vocab;

import core.tsc.lang.Translatable;

public enum OptionMenuLabel implements Translatable {

	LANGUAGE, SAVE_BUTTON, SCORE_TO_WIN, RULE;

	@Override
	public final String getXMLPath() {
		return "//label/option_menu/" + this.name().toLowerCase() + "/";
	}
}
