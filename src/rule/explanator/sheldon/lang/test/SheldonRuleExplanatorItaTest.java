package rule.explanator.sheldon.lang.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rule.explanator.sheldon.lang.SheldonRuleExplanatorIta;
import rule.explanator.sheldon.test.SheldonRuleExplanatorTest;

public class SheldonRuleExplanatorItaTest extends SheldonRuleExplanatorTest{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		sre = new SheldonRuleExplanatorIta();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public final void testExplain() {
		super.testExplain();
		// TODO: is there anything different really?
	}
	
	@Test
	public final void testGetLanguage() {
		assertEquals("Check what language is set in the SheldonRuleExplanationsIta class", "Italiano", sre.getLanguage());
	}

}
