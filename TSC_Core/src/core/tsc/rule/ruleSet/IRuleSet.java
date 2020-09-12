package core.tsc.rule.ruleSet;

import core.tsc.lang.Translatable;
import core.tsc.rule.ruleSet.exception.UnexpectedRuleSetException;


public interface IRuleSet extends Translatable {
	
	/**
	 * @param otherMove
	 *            move of the player we want to compare
	 * @return if this move beats the other
	 */
	public abstract boolean winsOver(IRuleSet otherMove) throws UnexpectedRuleSetException;
	
	/**
	 * @param otherMove
	 *            move of the player we want to compare
	 * @return whether the two moves tie
	 */
	public abstract boolean tiesWith(IRuleSet otherMove) throws UnexpectedRuleSetException;
	
}
