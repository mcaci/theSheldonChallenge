package player.test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import player.human.ConsolePlayer;
import rule.RuleList;

public class ConsolePlayerTest extends PlayerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		randRule = (int)(Math.random() * RuleList.values().length);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println(randRule + " Rule used: " + RuleList.values()[randRule]);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		p = new ConsolePlayer("TestConsolePlayer", RuleList.values()[randRule]);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

}
