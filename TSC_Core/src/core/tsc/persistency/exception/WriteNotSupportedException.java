package core.tsc.persistency.exception;

import java.io.PrintStream;

public final class WriteNotSupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6580892134327457998L;
	private static final String ERR_MSG = "does not support writing yet.";
	
	public WriteNotSupportedException(Object caller) {
		super();
		printMessage(caller.getClass().getName() + " " + ERR_MSG, System.err);
	}

	/**
	 * printMessage on some output
	 */
	@Deprecated
	private static final void printMessage(String msg, PrintStream out) {
		out.println(msg);
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
