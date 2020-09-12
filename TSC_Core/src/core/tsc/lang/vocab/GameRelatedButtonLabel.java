package core.tsc.lang.vocab;

import core.tsc.lang.Translatable;

public enum GameRelatedButtonLabel implements Translatable {

	START, SURRENDER, RANDOM, REMATCH;

	@Override
	public final String getXMLPath() {
		return "//buttonset/game/" + this.name().toLowerCase() + "/";
	}

}
