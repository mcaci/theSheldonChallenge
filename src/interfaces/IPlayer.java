/**
 * 
 */
package interfaces;

import exception.UnknownRuleException;
import move.Move;
import rule.RuleList;

/**
 * Interface to manage any kind of results writers
 * @author nikiforos
 */
public abstract interface IPlayer extends Runnable {

	/**
	 * Gets the choice from the player
	 * @return the move chosen by the player
	 * @throws UnknownRuleException 
	 */
	public abstract Move chooseMove(RuleList ruleUsed) throws UnknownRuleException;

	/**
	 * Updates the score of the player
	 * @param roundWinner
	 */
	public abstract void updateInfo(boolean roundWinner);
	
}