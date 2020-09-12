/**
 * 
 */
package player.human;

import java.util.Scanner;

import exception.NoPlayerNameException;
import exception.UnknownRuleException;

import move.Move;
import player.Player;
import rule.RuleList;
import rule.classic.ClassicRuleSet;
import rule.sheldon.SheldonRuleSet;

/**
 * @author nikiforos
 *
 */
public class ConsolePlayer extends Player {
	
	/**
	 * @param p
	 * @param ruleUsed
	 */
	public ConsolePlayer(String name, RuleList ruleUsed) throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
	}

	/* (non-Javadoc)
	 * @see player.IPlayer#chooseMove(rule.RuleList)
	 */
	@Override
	public final Move chooseMove(RuleList ruleUsed) throws UnknownRuleException {
		int choice = 0;
		Scanner in = new Scanner(System.in);
		
		switch(ruleUsed){
		case CLASSIC:
			System.out.print("Choose a move: [\"1\" = ROCK; \"2\" = PAPER; \"3\" = SCISSORS] --> ");
			do{
				choice = in.nextInt() - 1;
			} while ((choice < 0) || (choice > ClassicRuleSet.values().length - 1));
			System.out.println();
			return new Move(ClassicRuleSet.values()[choice]);
			
		case SHELDON:
			System.out.print("Choose a move: [\"1\" = ROCK; \"2\" = PAPER; \"3\" = SCISSORS; \"4\" = LIZARD; \"5\" = SPOCK] --> ");
			do{
				choice = in.nextInt() - 1;
			} while ((choice < 0) || (choice > SheldonRuleSet.values().length - 1));
			System.out.println();
			return new Move(SheldonRuleSet.values()[choice]);
			
		default:
			throw new UnknownRuleException();
			// code here is unreachable... no return statement
		}
	}

}
