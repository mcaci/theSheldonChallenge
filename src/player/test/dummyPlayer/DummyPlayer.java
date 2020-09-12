/**
 * 
 */
package player.test.dummyPlayer;

import player.AI.AIPlayer;
import rule.RuleList;
import exception.NoPlayerNameException;
import exception.UnknownRuleException;

/**
 * @author nikiforos
 * ATTENTION: this dummy Player is to be used ONLY for testing
 */
public final class DummyPlayer extends AIPlayer {

	/**
	 * @throws NoPlayerNameException 
	 * @throws UnknownRuleException 
	 * 
	 */
	public DummyPlayer() throws NoPlayerNameException, UnknownRuleException {
		super("DUMMY", RuleList.CLASSIC);
	}

}
