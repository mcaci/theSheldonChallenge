/**
 * 
 */
package core.tsc.player.exception;

import java.io.PrintStream;

/**
 * @author nikiforos
 * 
 */
public final class PlayerNotReadyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7420325358448048215L;

	private static final String ERROR_MESSAGE = "Player information is not correctly updated for new round... execution is stopped";

	/**
	 * 
	 */
	public PlayerNotReadyException() {
		super();
		printMessage(System.err);
	}

	/**
	 * @param arg0
	 */
	public PlayerNotReadyException(String arg0) {
		super(arg0);
		printMessage(System.err);
	}

	/**
	 * @param arg0
	 */
	public PlayerNotReadyException(Throwable arg0) {
		super(arg0);
		printMessage(System.err);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public PlayerNotReadyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		printMessage(System.err);
	}

	/**
	 * printMessage on some output
	 */
	@Deprecated
	private static final void printMessage(PrintStream out) {
		out.println(ERROR_MESSAGE);
		// System.exit(-1);
	}

	/**
	 * popus a window with the message error
	 */
	@SuppressWarnings("unused")
	private static final void popupMessage() {
		// TODO: popup message with same text
		// System.exit(-1);
	}
}
