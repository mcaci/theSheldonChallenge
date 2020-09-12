/**
 * 
 */
package player.AI;

import exception.UnknownRuleException;
import exception.NoPlayerNameException;
import move.Move;
import player.Player;
import rule.RuleList;
import rule.classic.ClassicRuleSet;
import rule.sheldon.SheldonRuleSet;

/**
 * @author nikiforos
 *
 */
public class AIPlayer extends Player {
	
	public AIPlayer(String name, RuleList ruleUsed) throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
	}

	@Override
	public final Move chooseMove(RuleList ruleUsed) throws UnknownRuleException {
		if(ruleUsed == null){
			throw new UnknownRuleException();
		}
		else {
			switch(ruleUsed){
			case CLASSIC:
				ClassicRuleSet clAction = ClassicRuleSet.values()[(int)(Math.random() * ClassicRuleSet.values().length)];
				return new Move(clAction); 
			case SHELDON:
				SheldonRuleSet sAction = SheldonRuleSet.values()[(int)(Math.random() * SheldonRuleSet.values().length)];
				return new Move(sAction);
			default:
				throw new UnknownRuleException();
				// code here is unreachable... no return statement
			}
		}
	}

}
