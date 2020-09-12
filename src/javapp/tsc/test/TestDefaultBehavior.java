/**
 * 
 */
package javapp.tsc.test;

/**
 * @author nikiforos
 * 
 */
final class TestDefaultBehavior {

	/**
	 * @throws java.lang.Exception
	 */
	static final void setUpBeforeClass() throws Exception {
		System.out.println("Executing setup before CLASS");
	}

	/**
	 * @throws java.lang.Exception
	 */
	static final void tearDownAfterClass() throws Exception {
		System.out.println("Executing teardown after CLASS");
	}

	/**
	 * @throws java.lang.Exception
	 */
	static final void setUp() throws Exception {
		System.out.println("Starting a TEST");
	}

	/**
	 * @throws java.lang.Exception
	 */
	static final void tearDown() throws Exception {
		System.out.println("Ending a TEST");
	}

}
