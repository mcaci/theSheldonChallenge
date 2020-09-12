package javapp.tsc.exception;

public final class UnrecognizedOptionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3897603574729753116L;
	
	private final static String errMessage = "Option not recognized: use \"-tsc\" to start the regular game or \"-cfp\" to start the console game";

	public UnrecognizedOptionException() {
		System.err.println(errMessage);
//		this.printStackTrace();
	}
}
