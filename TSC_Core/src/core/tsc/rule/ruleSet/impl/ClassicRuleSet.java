/**
 * 
 */
package core.tsc.rule.ruleSet.impl;

import core.tsc.rule.ruleSet.IRuleSet;
import core.tsc.rule.ruleSet.exception.UnexpectedRuleSetException;

/**
 * @author nikiforos
 * 
 */
public enum ClassicRuleSet implements IRuleSet {
	ROCK {
		@Override
		public final boolean winsOver(IRuleSet otherMove) throws UnexpectedRuleSetException {
			if (otherMove.equals(SCISSORS)) {
				return true;
			} else {
				return false;
			}
		}
	},
	PAPER {
		@Override
		public final boolean winsOver(IRuleSet otherMove) throws UnexpectedRuleSetException {
			if (otherMove.equals(ROCK)) {
				return true;
			} else {
				return false;
			}
		}
	},
	SCISSORS {
		@Override
		public final boolean winsOver(IRuleSet otherMove) throws UnexpectedRuleSetException {
			if (otherMove.equals(PAPER)) {
				return true;
			} else {
				return false;
			}
		}
	};
	

	@Override
	public final String getXMLPath() {
		return "//ruleset/classic/" + this.name().toLowerCase() + "/";
	}
	
	/**
	 * @param otherMove
	 *            move of the player we want to compare
	 * @return whether the two moves tie
	 */
	@Override
	public final boolean tiesWith(IRuleSet otherMove) throws UnexpectedRuleSetException {
		if(otherMove instanceof ClassicRuleSet)
			return this.equals(otherMove);
		else
			throw new UnexpectedRuleSetException();
	}
	
	public static String[] getStringVector() {
		ClassicRuleSet[] clVect = ClassicRuleSet.values();
		String[] stringVect = new String[clVect.length];
		for (int i = 0; i < clVect.length; i++) {
			stringVect[i] = clVect[i].name();
		}
		return stringVect;
	}
}
