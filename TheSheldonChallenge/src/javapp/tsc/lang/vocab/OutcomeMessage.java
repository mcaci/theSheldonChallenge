package javapp.tsc.lang.vocab;

import core.tsc.lang.Translatable;

public enum OutcomeMessage implements Translatable {

	LOSS, WIN, TIE;

	@Override
	public final String getXMLPath() {
		return "//message/outcome/" + this.name().toLowerCase() + "/";
	}
}
