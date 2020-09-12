package core.tsc.lang.vocab;

import core.tsc.lang.Translatable;

/**
 * Different labels for generic labels and buttonset
 * 
 * @author nikiforos
 * 
 */
public enum OtherLabel implements Translatable {

	ENTER_NAME, MOVE, SCORE;

	@Override
	public final String getXMLPath() {
		return "//label/" + this.name().toLowerCase() + "/";
	}
}
