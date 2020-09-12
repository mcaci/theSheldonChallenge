/**
 * 
 */
package javapp.tsc.player.impl.AI;

import javapp.tsc.player.impl.AliveForChoosingPlayer;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

/**
 * @author nikiforos Not final because of Dummy?
 */
public final class RandomPlayer extends AliveForChoosingPlayer {

	public RandomPlayer(String name, Rule ruleUsed)
			throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
	}

	@Override
	public final IRuleSet chooseMove(Rule ruleUsed) throws UnknownRuleException {
		if (ruleUsed == null) {
			throw new UnknownRuleException();
		} else {
			switch (ruleUsed) {
			case CLASSIC:
				return Rule.CLASSIC.randomValue();
			case SHELDON:
				return Rule.SHELDON.randomValue();
			default:
				throw new UnknownRuleException();
				// code here is unreachable... no return statement
			}
		}
	}

}
