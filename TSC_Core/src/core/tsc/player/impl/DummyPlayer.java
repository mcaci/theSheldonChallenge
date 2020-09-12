/**
 * 
 */
package core.tsc.player.impl;

import core.tsc.AppCore;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

/**
 * This player is not meant to be used in any situation than simulating the random move player (more or less like AI for now)
 * @author nikiforos
 */
public abstract class DummyPlayer extends DefaultPlayer {

	private DummyPlayer()
			throws NoPlayerNameException, UnknownRuleException {
		super("TestDummy", AppCore.getInstance().getSessionRule());
	}

	public static final IRuleSet chooseRandomMove(Rule ruleUsed){
		if (ruleUsed == null) {
			try {
				throw new UnknownRuleException();
			} catch (UnknownRuleException e) {
				e.printStackTrace();
			}
		} else {
			switch (ruleUsed) {
			case CLASSIC:
				return Rule.CLASSIC.randomValue();
			case SHELDON:
				return Rule.SHELDON.randomValue();
			default:
				try {
					throw new UnknownRuleException();
				} catch (UnknownRuleException e) {
					e.printStackTrace();
				}
				// code here is unreachable... no return statement
			}
		}
		return null;
	}

}
