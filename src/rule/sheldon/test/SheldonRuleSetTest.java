package rule.sheldon.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rule.sheldon.SheldonRuleSet;

public class SheldonRuleSetTest {

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
		assertTrue("Rock crushes Scissors", SheldonRuleSet.ROCK.winsOver(SheldonRuleSet.SCISSORS));
		assertTrue("Rock crushes Lizard", SheldonRuleSet.ROCK.winsOver(SheldonRuleSet.LIZARD));
		assertTrue("Paper covers Rock", SheldonRuleSet.PAPER.winsOver(SheldonRuleSet.ROCK));
		assertTrue("Paper disprooves Spock", SheldonRuleSet.PAPER.winsOver(SheldonRuleSet.SPOCK));
		assertTrue("Scissors cut Paper", SheldonRuleSet.SCISSORS.winsOver(SheldonRuleSet.PAPER));
		assertTrue("Scissors decapitates Lizard", SheldonRuleSet.SCISSORS.winsOver(SheldonRuleSet.LIZARD));
		assertTrue("Lizard eats Paper", SheldonRuleSet.LIZARD.winsOver(SheldonRuleSet.PAPER));
		assertTrue("Lizard poisons Spock", SheldonRuleSet.LIZARD.winsOver(SheldonRuleSet.SPOCK));
		assertTrue("Spock crushes Rock", SheldonRuleSet.SPOCK.winsOver(SheldonRuleSet.ROCK));
		assertTrue("Spock smashes Scissors", SheldonRuleSet.SPOCK.winsOver(SheldonRuleSet.SCISSORS));

		assertFalse("Rock still crushes Scissors", SheldonRuleSet.SCISSORS.winsOver(SheldonRuleSet.ROCK));
		assertFalse("Rock still crushes Lizard", SheldonRuleSet.LIZARD.winsOver(SheldonRuleSet.ROCK));
		assertFalse("Paper still covers Rock", SheldonRuleSet.ROCK.winsOver(SheldonRuleSet.PAPER));
		assertFalse("Paper still disprooves Spock", SheldonRuleSet.SPOCK.winsOver(SheldonRuleSet.PAPER));
		assertFalse("Scissors still cut Paper", SheldonRuleSet.PAPER.winsOver(SheldonRuleSet.SCISSORS));
		assertFalse("Scissors still decapitates Lizard", SheldonRuleSet.LIZARD.winsOver(SheldonRuleSet.SCISSORS));
		assertFalse("Lizard still eats Paper", SheldonRuleSet.PAPER.winsOver(SheldonRuleSet.LIZARD));
		assertFalse("Lizard still poisons Spock", SheldonRuleSet.SPOCK.winsOver(SheldonRuleSet.LIZARD));
		assertFalse("Spock still crushes Rock", SheldonRuleSet.ROCK.winsOver(SheldonRuleSet.SPOCK));
		assertFalse("Spock still smashes Scissors", SheldonRuleSet.SCISSORS.winsOver(SheldonRuleSet.SPOCK));
		
		assertFalse("Rock ties with Rock", SheldonRuleSet.ROCK.winsOver(SheldonRuleSet.ROCK));
		assertFalse("Paper ties with Paper", SheldonRuleSet.PAPER.winsOver(SheldonRuleSet.PAPER));
		assertFalse("Scissors ties with Scissors", SheldonRuleSet.SCISSORS.winsOver(SheldonRuleSet.SCISSORS));
		assertFalse("Lizard ties with Lizard", SheldonRuleSet.LIZARD.winsOver(SheldonRuleSet.LIZARD));
		assertFalse("Spock ties with Spock", SheldonRuleSet.SPOCK.winsOver(SheldonRuleSet.SPOCK));
	}

	@Test
	public final void testTiesWith() {
		assertFalse("Rock crushes Scissors", SheldonRuleSet.ROCK.tiesWith(SheldonRuleSet.SCISSORS));
		assertFalse("Rock crushes Lizard", SheldonRuleSet.ROCK.tiesWith(SheldonRuleSet.LIZARD));
		assertFalse("Paper covers Rock", SheldonRuleSet.PAPER.tiesWith(SheldonRuleSet.ROCK));
		assertFalse("Paper disprooves Spock", SheldonRuleSet.PAPER.tiesWith(SheldonRuleSet.SPOCK));
		assertFalse("Scissors cut Paper", SheldonRuleSet.SCISSORS.tiesWith(SheldonRuleSet.PAPER));
		assertFalse("Scissors decapitates Lizard", SheldonRuleSet.SCISSORS.tiesWith(SheldonRuleSet.LIZARD));
		assertFalse("Lizard eats Paper", SheldonRuleSet.LIZARD.tiesWith(SheldonRuleSet.PAPER));
		assertFalse("Lizard poisons Spock", SheldonRuleSet.LIZARD.tiesWith(SheldonRuleSet.SPOCK));
		assertFalse("Spock crushes Rock", SheldonRuleSet.SPOCK.tiesWith(SheldonRuleSet.ROCK));
		assertFalse("Spock smashes Scissors", SheldonRuleSet.SPOCK.tiesWith(SheldonRuleSet.SCISSORS));

		assertFalse("Rock still crushes Scissors", SheldonRuleSet.SCISSORS.tiesWith(SheldonRuleSet.ROCK));
		assertFalse("Rock still crushes Lizard", SheldonRuleSet.LIZARD.tiesWith(SheldonRuleSet.ROCK));
		assertFalse("Paper still covers Rock", SheldonRuleSet.ROCK.tiesWith(SheldonRuleSet.PAPER));
		assertFalse("Paper still disprooves Spock", SheldonRuleSet.SPOCK.tiesWith(SheldonRuleSet.PAPER));
		assertFalse("Scissors still cut Paper", SheldonRuleSet.PAPER.tiesWith(SheldonRuleSet.SCISSORS));
		assertFalse("Scissors still decapitates Lizard", SheldonRuleSet.LIZARD.tiesWith(SheldonRuleSet.SCISSORS));
		assertFalse("Lizard still eats Paper", SheldonRuleSet.PAPER.tiesWith(SheldonRuleSet.LIZARD));
		assertFalse("Lizard still poisons Spock", SheldonRuleSet.SPOCK.tiesWith(SheldonRuleSet.LIZARD));
		assertFalse("Spock still crushes Rock", SheldonRuleSet.ROCK.tiesWith(SheldonRuleSet.SPOCK));
		assertFalse("Spock still smashes Scissors", SheldonRuleSet.SCISSORS.tiesWith(SheldonRuleSet.SPOCK));
		
		assertTrue("Rock ties with Rock", SheldonRuleSet.ROCK.tiesWith(SheldonRuleSet.ROCK));
		assertTrue("Paper ties with Paper", SheldonRuleSet.PAPER.tiesWith(SheldonRuleSet.PAPER));
		assertTrue("Scissors ties with Scissors", SheldonRuleSet.SCISSORS.tiesWith(SheldonRuleSet.SCISSORS));
		assertTrue("Lizard ties with Lizard", SheldonRuleSet.LIZARD.tiesWith(SheldonRuleSet.LIZARD));
		assertTrue("Spock ties with Spock", SheldonRuleSet.SPOCK.tiesWith(SheldonRuleSet.SPOCK));
	}

}
