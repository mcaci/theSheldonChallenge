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
public enum SheldonRuleSet implements IRuleSet {
	ROCK {
		@Override
		public final boolean winsOver(IRuleSet otherMove) throws UnexpectedRuleSetException {
			if (otherMove.equals(SCISSORS)) {
				return true;
			} else if (otherMove.equals(LIZARD)) {
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
			} else if (otherMove.equals(SPOCK)) {
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
			} else if (otherMove.equals(LIZARD)) {
				return true;
			} else {
				return false;
			}
		}
	},
	LIZARD {
		@Override
		public final boolean winsOver(IRuleSet otherMove) throws UnexpectedRuleSetException {
			if (otherMove.equals(PAPER)) {
				return true;
			} else if (otherMove.equals(SPOCK)) {
				return true;
			} else {
				return false;
			}
		}
	},
	SPOCK {
		@Override
		public final boolean winsOver(IRuleSet otherMove) throws UnexpectedRuleSetException {
			if (otherMove.equals(SCISSORS)) {
				return true;
			} else if (otherMove.equals(ROCK)) {
				return true;
			} else {
				return false;
			}
		}
	};
	
	@Override
	public final String getXMLPath() {
		return "//ruleset/sheldon/" + this.name().toLowerCase() + "/";
	}
	
	public final boolean tiesWith(IRuleSet otherMove) throws UnexpectedRuleSetException {
		if(otherMove instanceof SheldonRuleSet)
			return this.equals(otherMove);
		else
			throw new UnexpectedRuleSetException();
	}

	public static String[] getStringVector() {
		SheldonRuleSet[] shVect = SheldonRuleSet.values();
		String[] stringVect = new String[shVect.length];
		for (int i = 0; i < shVect.length; i++) {
			stringVect[i] = shVect[i].name();
		}
		return stringVect;
	}
}
