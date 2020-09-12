package exception;

import java.io.PrintStream;

import player.PlayerStates;

public class InvalidStateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3437815738162462770L;

	private static String errMessage = "";

	/**
	 * 
	 */
	public InvalidStateException(PlayerStates stateToCheck, PlayerStates expectedState) {
		super();
		errMessage = "Player is not meant to be in the state " + stateToCheck.name() +
						" but in the state " + expectedState.name();
		printMessage(System.err);
	}

	/**
	 * printMessage on some output
	 */
	@Deprecated
	private static final void printMessage(PrintStream out) {
		out.println(errMessage);
		System.exit(-1);
	}
	
	/**
	 * popus a window with the message error
	 */
	@SuppressWarnings("unused")
	private static final void popupMessage() {
		//TODO: popup message with same text
		System.exit(-1);
	}
}
