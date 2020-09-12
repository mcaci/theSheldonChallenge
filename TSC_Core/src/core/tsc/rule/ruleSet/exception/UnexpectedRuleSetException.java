/**
 * 
 */
package core.tsc.rule.ruleSet.exception;

import java.io.PrintStream;

/**
 * @author nikiforos
 *
 */
public class UnexpectedRuleSetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5092515118535499962L;
	
	// TODO: to specify better
	private static final String ERROR_MESSAGE = "Rules being compared are not the same";

	/**
	 * 
	 */
	public UnexpectedRuleSetException() {
		printMessage(System.err);
	}

	/**
	 * @param message
	 */
	public UnexpectedRuleSetException(String message) {
		super(message);
		printMessage(System.err);
	}

	/**
	 * @param cause
	 */
	public UnexpectedRuleSetException(Throwable cause) {
		super(cause);
		printMessage(System.err);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnexpectedRuleSetException(String message, Throwable cause) {
		super(message, cause);
		printMessage(System.err);
	}

	/**
	 * printMessage on some output
	 */
	@Deprecated
	private static final void printMessage(PrintStream out) {
		out.println(ERROR_MESSAGE);
		System.exit(-1);
	}

	/**
	 * popus a window with the message error
	 */
	@SuppressWarnings("unused")
	private static final void popupMessage() {
		// TODO: popup message with same text
		System.exit(-1);
	}

}
