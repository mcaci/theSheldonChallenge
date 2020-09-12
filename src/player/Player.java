/**
 * 
 */
package player;

import interfaces.IPlayer;
import move.Move;
import rule.RuleList;
import exception.InvalidStateException;
import exception.NoPlayerNameException;
import exception.PlayerNotReadyException;
import exception.UnknownRuleException;
import gameSession.GameSession;


/**
 * @author nikiforos
 *
 */
public abstract class Player implements IPlayer {
	
	// player info
	private String id;
	private int score = 0;
	private Move move = new Move(null);
	private PlayerStates currentState;
	private RuleList ruleUsed;

	private boolean roundWinner = false;
	
	private boolean gameWinner = false;
	
	
	/**
	 * 
	 */
	public Player(String name, RuleList ruleUsed) throws NoPlayerNameException, UnknownRuleException {
		// creating state
		this.setCurrentState(PlayerStates.CREATING);
		
		// setting parameters
		if(name == null || ruleUsed == null){
			if(name == null) throw new NoPlayerNameException();
			if(ruleUsed == null) throw new UnknownRuleException();
		}
		else{
			this.setId(name);
			this.setRuleUsed(ruleUsed);
		}
		
		// ready to play state
		this.setCurrentState(PlayerStates.READY_TO_PLAY);
	}
	
	@Override
	public void run() {
		
		try {
			// playing state
			this.setPlaying();
			
			// choose move
			this.setMove(this.chooseMove(ruleUsed));
			
			// performed move state
			this.setPerformedMove();
			
		}
		catch (UnknownRuleException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				// consistency check of the state after the choice
				this.checkIfCurrentStateIs(PlayerStates.PERFORMED_MOVE);
				
			} catch (InvalidStateException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see player.IPlayer#updateInfo(boolean)
	 */
	@Override
	public void updateInfo(boolean roundWinner) {
		// updating state
		this.setCurrentState(PlayerStates.UPDATING);
		
		// updates if player is a round winner
		if(roundWinner){
			// new score
			int newScore = this.getPoints() + 1;
			this.setPoints(newScore);
			// check for win
			gameWinner = GameSession.checkGameWinner(newScore);
			if(gameWinner){
				// if true set exit mode
				this.setGameWinner(true);
				this.setCurrentState(PlayerStates.EXITING_GAME);
			}
			else{
				// else complete setup to continue
				this.setRoundWinner(false);
			}
		}
		// updates to do anyway
		this.getMove().setPlayerMove(null);
		
		// TODO: here? ready to play state?
		this.setCurrentState(PlayerStates.READY_TO_PLAY);
	}
	
	/**
	 * if the check is positive the computation continues otherwise it exits
	 * and launches an exception
	 * @param stateToCheck the state we want to check against the currentState
	 */
	protected final void checkIfCurrentStateIs(PlayerStates stateToCheck) throws InvalidStateException {
		if(!this.getCurrentState().equals(stateToCheck)){
			throw new InvalidStateException(this.getCurrentState(), stateToCheck);
		}
		else{
			// good to go
		}
	}
	
	/**
	 * TODO: necessary???
	 */
	public final boolean checkReadyToPlayState() throws PlayerNotReadyException {
		boolean flag = true;
		
		flag &= (this.getMove().getPlayerMove() == null);
		flag &= (this.getCurrentState().equals(PlayerStates.READY_TO_PLAY));
		flag &= (!this.isRoundWinner());
		flag &= (!this.isGameWinner());
		
		if(flag)
			return flag;
		else{
			throw new PlayerNotReadyException();
		}
	}
	
	/**
	 * TODO: necessary???
	 */
	public final void exitFromGame() {
		if(!this.getCurrentState().equals(PlayerStates.EXITING_GAME)){
			this.setCurrentState(PlayerStates.EXITING_GAME);
		}
//		System.exit(0);
	}

	protected final void setPlaying() {
		this.setCurrentState(PlayerStates.PLAYING);
	}
	
	protected final void setPerformedMove() {
		this.setCurrentState(PlayerStates.PERFORMED_MOVE);
	}
	
	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final int getPoints() {
		return score;
	}

	public final void setPoints(int points) {
		this.score = points;
	}

	public final Move getMove() {
		return move;
	}

	public final void setMove(Move move) {
		this.move = move;
	}

	public final PlayerStates getCurrentState() {
		return currentState;
	}

	public final void setCurrentState(PlayerStates currentState) {
		this.currentState = currentState;
	}

	public final RuleList getRuleUsed() {
		return ruleUsed;
	}

	public final void setRuleUsed(RuleList ruleUsed) {
		this.ruleUsed = ruleUsed;
	}

	public final boolean isRoundWinner() {
		return roundWinner;
	}

	public final void setRoundWinner(boolean roundWinner) {
		this.roundWinner = roundWinner;
	}

	public final boolean isGameWinner() {
		return gameWinner;
	}

	public final void setGameWinner(boolean gameWinner) {
		this.gameWinner = gameWinner;
	}

}
