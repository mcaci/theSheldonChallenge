package rule.explanator.classic.lang.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rule.explanator.classic.lang.ClassicRuleExplanatorEng;
import rule.explanator.classic.test.ClassicRuleExplanatorTest;

public class ClassicRuleExplanatorEngTest extends ClassicRuleExplanatorTest{
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		cre = new ClassicRuleExplanatorEng();
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
		assertEquals("Check what language is set in the ClassicRuleExplanationsEng class", "English", cre.getLanguage());
	}

}
