/**
 * 
 */
package javapp.tsc.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author nikiforos
 * 
 */
public class DefaultUTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestDefaultBehavior.setUpBeforeClass();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		TestDefaultBehavior.tearDownAfterClass();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		TestDefaultBehavior.setUp();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		TestDefaultBehavior.tearDown();
	}

	protected void testNotImplementedYet() {
		fail("Not yet implemented for class: "
				+ this.getClass().getSimpleName());
	}

}
