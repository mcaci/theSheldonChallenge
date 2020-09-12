/**
 * 
 */
package player.human;

import move.Move;
import player.Player;
import rule.RuleList;
import exception.NoPlayerNameException;
import exception.UnknownRuleException;

/**
 * @author nikiforos
 *
 */
public class GUIPlayer extends Player {
	
	/**
	 * @param p
	 * @param ruleUsed
	 */
	public GUIPlayer(String name, RuleList ruleUsed) throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
	}
		// TODO: totally wrong this thing
//		this.data = MainFrame.getData();

	/* (non-Javadoc)
	 * @see player.IPlayer#chooseMove(rule.RuleList)
	 */
	@Override
	public final Move chooseMove(RuleList ruleUsed) throws UnknownRuleException {
		
		switch(ruleUsed){
		case CLASSIC:
			return null; 
		case SHELDON:
			return null;
		default: 
			throw new UnknownRuleException();
			// code here is unreachable... no return statement
		}
	}

	/**
	 * TODO: I'm not sure it's always going to be on or with data...
	 * @return the data
	 */
//	protected GUIData getData() {
//		return MainFrame.getData();
//	}

}
