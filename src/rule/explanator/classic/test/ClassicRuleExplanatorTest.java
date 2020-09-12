package rule.explanator.classic.test;

import static org.junit.Assert.assertNotNull;
import move.Move;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import player.Player;
import rule.RuleList;
import rule.classic.ClassicRuleSet;
import rule.explanator.classic.ClassicRuleExplanator;

public abstract class ClassicRuleExplanatorTest {
	
	protected ClassicRuleExplanator cre;
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
			public void run() {}
			
			@Override
			public Move chooseMove(RuleList ruleUsed) {return null;}
		};
		cre = null;
		p1.setRoundWinner(false);
		p1.setMove(new Move(ClassicRuleSet.SCISSORS));
		
		// SET P2 (needs Move)
		p2 = new Player("", RuleList.CLASSIC) {			
			// not important but necessary for correctness
			@Override
			public void run() {}
			
			@Override
			public Move chooseMove(RuleList ruleUsed) {return null;}
		};
		cre = null;
		p2.setRoundWinner(false);
		p2.setMove(new Move(ClassicRuleSet.PAPER));
		
		
		System.out.println("a new test is beginning");
	}

	@After
	public void tearDown() throws Exception {
		cre = null;
		p1 = null;
		p2 = null;
		System.out.println("test is ending");
	}

	@Test
	public void testExplain() {
		String explanation = cre.explain(p1, p2);
		assertNotNull("explain could not return properly", explanation);
		System.out.println(explanation);
		// TODO: could be thoroughly explored
	}

	@Test
	public abstract void testGetLanguage();

}
