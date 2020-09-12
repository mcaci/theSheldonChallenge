package interfaces;

import player.Player;

public interface IRuleExplanator {
	
	/**
	 * Method that return the explanation to the outcome from the moves of two Players
	 * @param p1
	 * @param p2
	 * @return
	 */
	public String explain(Player p1, Player p2);
}
