/**
 * 
 */
package core.tsc.player.exception;

import java.io.PrintStream;

/**
 * @author nikiforos
 * 
 */
public final class UnknownRuleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2192970811003734396L;

	private static final String ERROR_MESSAGE = "Player isn't aware of this rule... maybe in the code it isn't specified";

	/**
	 * 
	 */
	public UnknownRuleException() {
		printMessage(System.err);
	}

	/**
	 * @param message
	 */
	public UnknownRuleException(String message) {
		super(message);
		printMessage(System.err);
	}

	/**
	 * @param cause
	 */
	public UnknownRuleException(Throwable cause) {
		super(cause);
		printMessage(System.err);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnknownRuleException(String message, Throwable cause) {
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
