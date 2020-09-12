package rule.classic.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rule.classic.ClassicRuleSet;

public class ClassicRuleSetTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Test begins");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Test ends");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Something begins");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Something ends");
	}

	@Test
	public final void testWinsOver() {
		assertTrue("Rock crushes Scissors", ClassicRuleSet.ROCK.winsOver(ClassicRuleSet.SCISSORS));
		assertTrue("Paper covers Rock", ClassicRuleSet.PAPER.winsOver(ClassicRuleSet.ROCK));
		assertTrue("Scissors cut Paper", ClassicRuleSet.SCISSORS.winsOver(ClassicRuleSet.PAPER));
		
		assertFalse("Rock still crushes Scissors", ClassicRuleSet.SCISSORS.winsOver(ClassicRuleSet.ROCK));
		assertFalse("Paper still covers Rock", ClassicRuleSet.ROCK.winsOver(ClassicRuleSet.PAPER));
		assertFalse("Scissors still cut Paper", ClassicRuleSet.PAPER.winsOver(ClassicRuleSet.SCISSORS));
		
		assertFalse("Rock ties with Rock", ClassicRuleSet.ROCK.winsOver(ClassicRuleSet.ROCK));
		assertFalse("Paper ties with Paper", ClassicRuleSet.PAPER.winsOver(ClassicRuleSet.PAPER));
		assertFalse("Scissors ties with Scissors", ClassicRuleSet.SCISSORS.winsOver(ClassicRuleSet.SCISSORS));
	}

	@Test
	public final void testTiesWith() {
		assertFalse("Rock crushes Scissors", ClassicRuleSet.ROCK.tiesWith(ClassicRuleSet.SCISSORS));
		assertFalse("Paper covers Rock", ClassicRuleSet.PAPER.tiesWith(ClassicRuleSet.ROCK));
		assertFalse("Scissors cut Paper", ClassicRuleSet.SCISSORS.tiesWith(ClassicRuleSet.PAPER));
		
		assertFalse("Rock still crushes Scissors", ClassicRuleSet.SCISSORS.tiesWith(ClassicRuleSet.ROCK));
		assertFalse("Paper still covers Rock", ClassicRuleSet.ROCK.tiesWith(ClassicRuleSet.PAPER));
		assertFalse("Scissors still cut Paper", ClassicRuleSet.PAPER.tiesWith(ClassicRuleSet.SCISSORS));
		
		assertTrue("Rock ties with Rock", ClassicRuleSet.ROCK.tiesWith(ClassicRuleSet.ROCK));
		assertTrue("Paper ties with Paper", ClassicRuleSet.PAPER.tiesWith(ClassicRuleSet.PAPER));
		assertTrue("Scissors ties with Scissors", ClassicRuleSet.SCISSORS.tiesWith(ClassicRuleSet.SCISSORS));
	}

}
