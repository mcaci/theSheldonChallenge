/**
 * 
 */
package player.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import player.Player;
import player.PlayerStates;
import rule.RuleList;
import exception.PlayerNotReadyException;
import exception.UnknownRuleException;

/**
 * @author nikiforos
 *
 */
public abstract class PlayerTest {
	
	Player p;
	static int randRule;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		p = null;
	}

	/**
	 * Test method for {@link player.Player#run()}.
	 */
	@Test
	public final void testRun() {
		p.run();
		assertNotNull("Player has chosen", p.getMove().getPlayerMove());
		assertTrue("and this is still correct", p.getMove().isMoveChosen());
	}
	
	@Test
	public final void testChooseMove() {
		try {
			assertNotNull("Player has chosen", p.chooseMove(RuleList.CLASSIC));
			assertNotNull("Player has chosen", p.chooseMove(RuleList.SHELDON));
//			assertNull("Player can't choose", p.chooseMove(null));
		} catch (UnknownRuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for {@link player.Player#updateInfo(boolean)}.
	 */
	@Test
	public final void testUpdateInfo() {
		int score = p.getPoints();
		p.updateInfo(false);
		assertTrue(p.getPoints() == score);
		
		p.updateInfo(true);
		assertTrue(p.getPoints() == score + 1);
		
		assertTrue(p.getMove().getPlayerMove() == null);
		assertTrue(p.getCurrentState().equals(PlayerStates.READY_TO_PLAY));
		
	}

	/**
	 * Test method for {@link player.Player#checkReadyToPlayState()}.
	 */
	@Test
	public final void testCheckReadyToPlayState() {
		try {
			assertTrue("fields let the player to be ready", p.checkReadyToPlayState());
		} catch (PlayerNotReadyException e) {
			System.out.println("player found not ready");
		}
	}

	/**
	 * Test method for {@link player.Player#exitFromGame()}.
	 */
	@Test
	public final void testExitFromGame() {
		p.exitFromGame();
		assertTrue(p.getCurrentState().equals(PlayerStates.EXITING_GAME));
	}

}
