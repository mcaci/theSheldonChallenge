package core.tsc.player.impl;

import core.tsc.ipc.ISynchro;
import core.tsc.player.IPlayer;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.util.InGameStatus;
import core.tsc.player.util.PlayerStatus;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

public abstract class DefaultPlayer implements IPlayer {

	// player info
	private String name;
	private int score = 0;
	private Rule ruleUsed;
	private IRuleSet move = null;
	private InGameStatus playerState;
	private PlayerStatus playerStatus;
	private ISynchro notifier = null;
	
	/**
	 * 
	 */
	public DefaultPlayer(String name, Rule ruleUsed) throws NoPlayerNameException,
			UnknownRuleException {
		// creating state
		this.setPlayerState(InGameStatus.CREATING);
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
		this.setPlayerState(InGameStatus.READY_TO_PLAY);
	}
	
	@Override
	public String toString() {
		return this.getName() + ": " + this.getScore() + " <" + this.getMove() + ">";
	}

	
	/************************ GETTER AND SETTERS ************************/

	protected final void setName(String name) {
		this.name = name;
	}

	@Override
	public final String getName() {
		return name;
	}

	protected final void setScore(int score) {
		this.score = score;
	}

	@Override
	public final int getScore() {
		return score;
	}

	protected final void setRuleUsed(Rule ruleUsed) {
		this.ruleUsed = ruleUsed;
	}

	@Override
	public final Rule getRuleUsed() {
		return ruleUsed;
	}

	protected final void setMove(IRuleSet move) {
		this.move = move;
	}

	@Override
	public final IRuleSet getMove() {
		return move;
	}

	@Override
	public final void setPlayerState(InGameStatus currentState) {
		this.playerState = currentState;
	}
	
	protected final void setPlaying() {
		this.setPlayerState(InGameStatus.PLAYING);
	}

	protected final void setPerformedMove() {
		this.setPlayerState(InGameStatus.PERFORMED_MOVE);
	}

	@Override
	public final InGameStatus getPlayerState() {
		return playerState;
	}

	@Override
	public final boolean checkIfPlayerStateIs(InGameStatus stateToCheck) {
		return this.getPlayerState().equals(stateToCheck);
	}
	
	@Override
	public final void exitFromGame() throws UnsuccessfulUpdateException {
		if (!this.checkIfPlayerStateIs(InGameStatus.READY_TO_EXIT)) {
			this.setPlayerState(InGameStatus.READY_TO_EXIT);
		}
		this.setPlayerState(InGameStatus.EXITING_GAME);
	}

	@Override
	public final void setPlayerStatus(PlayerStatus playerStatus){
		this.playerStatus = playerStatus;
	}

	@Override
	public final PlayerStatus getPlayerStatus(){
		return this.playerStatus;
	}
	
	@Override
	public final void setNotifier(ISynchro notifier) {
		this.notifier  = notifier;
	}
	
	protected final ISynchro getNotifier() {
		return this.notifier;
	}
	
}
