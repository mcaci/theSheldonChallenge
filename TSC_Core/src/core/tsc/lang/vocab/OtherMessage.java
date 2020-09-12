package core.tsc.lang.vocab;

import core.tsc.lang.Translatable;

/**
 * Different text messages
 * 
 * @author nikiforos
 * 
 */
public enum OtherMessage implements Translatable {
	END_GAME, FORFEIT, CREDITS, TIE;

	@Override
	public final String getXMLPath() {
		return "//message/" + this.name().toLowerCase() + "M/";
	}
}
