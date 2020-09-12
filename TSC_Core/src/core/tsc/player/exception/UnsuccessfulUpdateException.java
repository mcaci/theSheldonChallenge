package core.tsc.player.exception;

import java.io.PrintStream;

public final class UnsuccessfulUpdateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4683247706946801981L;

	// TODO: to organize better
	private static final String ERROR_MESSAGE = "Update was unsuccessful";

	/**
	 * 
	 */
	public UnsuccessfulUpdateException() {
		printMessage(System.err);
	}

	/**
	 * @param message
	 */
	public UnsuccessfulUpdateException(String message) {
		super(message);
		printMessage(System.err);
	}

	/**
	 * @param cause
	 */
	public UnsuccessfulUpdateException(Throwable cause) {
		super(cause);
		printMessage(System.err);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnsuccessfulUpdateException(String message, Throwable cause) {
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
