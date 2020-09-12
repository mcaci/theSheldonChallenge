package core.tsc.lang.vocab;

import core.tsc.lang.Translatable;

/**
 * Different labels for the number of player buttonset
 * 
 * @author nikiforos
 * 
 */
public enum PlayerButtonLabel implements Translatable {
	ONE_PLAYER, TWO_PLAYERS;

	@Override
	public final String getXMLPath() {
		return "//buttonset/player_number/"
				+ this.name().split("_")[0].toLowerCase() + "/";
	}
}
