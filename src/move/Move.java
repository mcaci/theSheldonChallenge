/**
 * 
 */
package move;

/**
 * @author nikiforos
 *
 */
public class Move {

	protected Enum<?> playerMove;
	
	/**
	 * This constructor just builds the object and can be null
	 * for testing only (now)
	 * @param move The enum value to set in the move. If null, no move chosen
	 */
	public Move(Enum<?> move){
		this.setPlayerMove(move);
	}
	
	/**
	 * Check whether the move has been made (initialized to some value) or not
	 */
	public boolean isMoveChosen() {
		return playerMove != null;
	}

	/**
	 * @return the playerMove
	 */
	public Enum<?> getPlayerMove() {
		return playerMove;
	}

	/**
	 * @param playerMove the playerMove to set
	 */
	public void setPlayerMove(Enum<?> playerMove) {
		this.playerMove = playerMove;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getPlayerMove().name();
	}
	
}
