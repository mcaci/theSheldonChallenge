package rule.explanator.sheldon.test;

import static org.junit.Assert.assertNotNull;
import move.Move;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import player.Player;
import rule.RuleList;
import rule.explanator.sheldon.SheldonRuleExplanator;
import rule.sheldon.SheldonRuleSet;

public abstract class SheldonRuleExplanatorTest {

	protected SheldonRuleExplanator sre;
	protected Player p1, p2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		// SET P1 (needs Move)
		p1 = new Player("", RuleList.CLASSIC) {
			// not important but necessary for correctness
			@Override
			public void run() {
			}

			@Override
			public Move chooseMove(RuleList ruleUsed) {
				return null;
			}
		};
		sre = null;
		p1.setRoundWinner(true);
		p1.setMove(new Move(SheldonRuleSet.SCISSORS) {
		});

		// SET P2 (needs Move)
		p2 = new Player("", RuleList.CLASSIC) {
			// not important but necessary for correctness
			@Override
			public void run() {
			}

			@Override
			public Move chooseMove(RuleList ruleUsed) {
				return null;
			}
		};
		sre = null;
		p2.setRoundWinner(false);
		p2.setMove(new Move(SheldonRuleSet.LIZARD) {
		});

		System.out.println("a new test is beginning");
	}

	@After
	public void tearDown() throws Exception {
		sre = null;
		p1 = null;
		p2 = null;
		System.out.println("test is ending");
	}

	@Test
	public void testExplain() {
		String explanation = sre.explain(p1, p2);
		assertNotNull("explain could not return properly", explanation);
		System.out.println(explanation);
		// TODO: could be thoroughly explored
	}

	@Test
	public abstract void testGetLanguage();

}
