package rule.explanator;

import interfaces.IRuleExplanator;
import player.Player;

public abstract class RuleExplanator implements IRuleExplanator {

	private Player eventualWinner;
	private Player eventualLoser;
	
	/**
	 * @param winner Player 1
	 * @param loser Player 2
	 */
	protected void tellPlayersApart(Player winner, Player loser) {
		// Conditional Operator ?: - (condition ? whatIfTrue : whatIfFalse); -- not used here
		this.setEventualWinner(winner);
		this.setEventualLoser(loser);
	}

	/**
	 * @param eventualWinner the eventualWinner to set
	 */
	protected final void setEventualWinner(Player eventualWinner) {
		this.eventualWinner = eventualWinner;
	}

	/**
	 * @return the eventualWinner
	 */
	protected final Player getEventualWinner() {
		return eventualWinner;
	}

	/**
	 * @param eventualLoser the eventualLoser to set
	 */
	protected final void setEventualLoser(Player eventualLoser) {
		this.eventualLoser = eventualLoser;
	}

	/**
	 * @return the eventualLoser
	 */
	protected final Player getEventualLoser() {
		return eventualLoser;
	}

}
