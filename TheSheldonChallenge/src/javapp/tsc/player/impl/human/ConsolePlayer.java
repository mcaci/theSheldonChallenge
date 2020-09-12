/**
 * 
 */
package javapp.tsc.player.impl.human;

import java.util.Scanner;

import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.afc.AliveForChoosingPlayer;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

/**
 * @author nikiforos
 * 
 */
public final class ConsolePlayer extends AliveForChoosingPlayer {

	/**
	 * @param p
	 * @param ruleUsed
	 */
	public ConsolePlayer(String name, Rule ruleUsed)
			throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see player.IPlayer#chooseMove(rule.RuleList)
	 */
	@Override
	public final IRuleSet chooseMove(Rule ruleUsed) throws UnknownRuleException {
		int choice = 0;
		Scanner in = new Scanner(System.in);

		switch (ruleUsed) {
		case CLASSIC:
			System.out
					.print("Choose a move: [\"1\" = ROCK; \"2\" = PAPER; \"3\" = SCISSORS] --> ");
			do {
				choice = in.nextInt() - 1;
			} while ((choice < 0)
					|| (choice > ClassicRuleSet.values().length - 1));
			System.out.println();
			return ClassicRuleSet.values()[choice];

		case SHELDON:
			System.out
					.print("Choose a move: [\"1\" = ROCK; \"2\" = PAPER; \"3\" = SCISSORS; \"4\" = LIZARD; \"5\" = SPOCK] --> ");
			do {
				choice = in.nextInt() - 1;
			} while ((choice < 0)
					|| (choice > SheldonRuleSet.values().length - 1));
			return SheldonRuleSet.values()[choice];

		default:
			throw new UnknownRuleException();
			// code here is unreachable... no return statement
		}
	}

}
