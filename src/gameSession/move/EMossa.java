/**
 *
 */
package gameSession.move;

/**
 * Enumeration of the possible moves
 * @author nikiforos
 */
public enum EMossa {
	CARTA, FORBICE, PIETRA;
	
	/**
	 * Converts a String to a Move -- need exception handler
	 * @param mossa
	 * @return
	 */
	public final static EMossa string2mossa(String mossa){
		if(mossa.equals("CARTA")) return CARTA;
		if(mossa.equals("FORBICE")) return FORBICE;
		if(mossa.equals("PIETRA")) return PIETRA;
		return null;
	}
}