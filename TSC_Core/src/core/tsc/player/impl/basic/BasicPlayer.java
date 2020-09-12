package core.tsc.player.impl.basic;

import core.tsc.player.IPlayer;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.util.PlayerState;
import core.tsc.player.util.PlayerStatus;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

public abstract class BasicPlayer implements IPlayer {

	// player info
	private String name;
	private int score = 0;
	private Rule ruleUsed;
	private IRuleSet move = null;
	private PlayerState playerState;
	private PlayerStatus playerStatus;
	
	/**
	 * Just for DummyPlayer so that I don't have to write a constructor there
	 */
	BasicPlayer(){}

	/**
	 * 
	 */
	public BasicPlayer(String name, Rule ruleUsed) throws NoPlayerNameException,
			UnknownRuleException {
		// creating state
		this.setPlayerState(PlayerState.CREATING);
		this.setPlayerStatus(PlayerStatus.NOT_A_WINNER);

		// setting parameters
		if (name == null || ruleUsed == null) {
			if (name == null)
				throw new NoPlayerNameException();
			if (ruleUsed == null)
				throw new UnknownRuleException();
		} else {
			this.setName(name);
			this.setRuleUsed(ruleUsed);			
		}

		// ready to play state
		this.setPlayerState(PlayerState.READY_TO_PLAY);
	}
	
	/**
	 * if the check is positive the computation continues otherwise it exits and
	 * launches an exception
	 * 
	 * @param stateToCheck
	 *            the state we want to check against the currentState
	 */
	private final static boolean checkIfPlayerStateIs(IPlayer p, PlayerState stateToCheck) {
		return p.getPlayerState().equals(stateToCheck);
	}
	
	public final boolean checkIfPlayerStateIs(PlayerState stateToCheck) {
		return checkIfPlayerStateIs(this, stateToCheck);
	}
	
	/************************ GETTER AND SETTERS ************************/

	protected final void setName(String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	protected final void setScore(int score) {
		this.score = score;
	}

	public final int getScore() {
		return score;
	}

	protected final void setRuleUsed(Rule ruleUsed) {
		this.ruleUsed = ruleUsed;
	}

	public final Rule getRuleUsed() {
		return ruleUsed;
	}

	protected final void setMove(IRuleSet move) {
		this.move = move;
	}

	public final IRuleSet getMove() {
		return move;
	}

	protected final void setPlayerState(PlayerState currentState) {
		this.playerState = currentState;
	}

	public final PlayerState getPlayerState() {
		return playerState;
	}

	protected final void setPlayerStatus(PlayerStatus playerStatus){
		this.playerStatus = playerStatus;
	}

	public final PlayerStatus getPlayerStatus(){
		return this.playerStatus;
	}

}
