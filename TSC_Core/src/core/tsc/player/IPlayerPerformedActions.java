/**
 * 
 */
package core.tsc.player;

import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.util.PlayerState;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

/**
 * @author nikiforos
 *
 */
interface IPlayerPerformedActions {

	/**
	 * Gets the choice from the player
	 * 
	 * @return the move chosen by the player
	 * @throws UnknownRuleException
	 */
	public abstract IRuleSet chooseMove(Rule ruleUsed) throws UnknownRuleException;

	/**
	 * Updates the score of the player
	 * 
	 * @param roundWinner
	 */
	public abstract void updateInfo(UpdateContext context) throws UnsuccessfulUpdateException;
	
	public abstract boolean checkIfPlayerStateIs(PlayerState stateToCheck);
}
