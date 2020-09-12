/**
 * 
 */
package javapp.tsc.player.impl;

import javapp.tsc.core.IntercomCore;
import javapp.tsc.gameSession.impl.regular.RoundBasedGS;
import javapp.tsc.mediation.playerGR.PlayerRoundMediator;
import core.tsc.player.UpdateContext;
import core.tsc.player.exception.InvalidStateException;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.impl.basic.BasicPlayer;
import core.tsc.player.util.PlayerState;
import core.tsc.player.util.PlayerStatus;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

/**
 * @author nikiforos
 * 
 */
public abstract class AliveForChoosingPlayer extends BasicPlayer {

	private PlayerRoundMediator playerMediator;

	/**
	 * 
	 */
	public AliveForChoosingPlayer(String name, Rule ruleUsed)
			throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
		this.playerMediator = IntercomCore.getInstance().getPGRCom();
	}

	@Override
	public synchronized final void run() {

		while (!Thread.interrupted()) {
			try {
				// wait for prompt from game round
				this.playerMediator.waitForGameRound();

				// playing state
				this.setPlaying();

				// choose move
				this.setMove(this.chooseMove(this.getRuleUsed()));

				// performed move state
				this.setPerformedMove();

				// interrupt to exit
				Thread.currentThread().interrupt();

				// consistent state check TODO: really necessary?
				if (!this.getPlayerState().equals(PlayerState.PERFORMED_MOVE)) {
					throw new InvalidStateException(this.getPlayerState(),
							PlayerState.PERFORMED_MOVE);
				}

				// notify game round
				this.playerMediator.notifyGameRound();

			} catch (UnknownRuleException e) {
				e.printStackTrace();
			} catch (InvalidStateException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public abstract IRuleSet chooseMove(Rule ruleUsed)
			throws UnknownRuleException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see player.IPlayer#updateInfo(boolean)
	 */
	@Override
	public final void updateInfo(UpdateContext context)
			throws UnsuccessfulUpdateException {
//		TODO: it won't work now until I change this code
//		context.executeUpdate(this);
//		throw new UnsuccessfulUpdateException();
		
		switch(context){
		case END_OF_ROUND:
				this.setPlayerState(PlayerState.UPDATING);

				// updates if player is a round winner
				if (this.getPlayerStatus().isRoundWinner()) {
					// new score
					int newScore = this.getScore() + 1;
					this.setScore(newScore);
					// check for win
					this.setPlayerStatus(RoundBasedGS.checkGameWinner(this));
					// and updates player if is the game winner
					if (this.getPlayerStatus().isGameWinner()) {
						// if true set exit mode
						this.setPlayerState(PlayerState.READY_TO_EXIT);
					} else {
						// else complete setup to continue (do something?)
					}
				}
				// updates to do anyway
				this.setMove(null);

				// TODO: is it to be put here the "ready to play" state? think so...
				// tests
				this.setPlayerState(PlayerState.READY_TO_PLAY);
				break;
		case WON_ROUND:
				this.setPlayerStatus(PlayerStatus.ROUND_WINNER);
				break;
		case END_OF_GAME:
				if (!this.getPlayerState().equals(PlayerState.READY_TO_EXIT)) {
					this.setPlayerState(PlayerState.READY_TO_EXIT);
				}
				this.setPlayerState(PlayerState.EXITING_GAME);
				break;
		}
		
	}

	/**
	 * it's just unused... keeping it here just to have an implementation of
	 * Cloneable
	 */
	@Override
	@Deprecated
	public final AliveForChoosingPlayer clone() {
		AliveForChoosingPlayer clone = null;
		try {
			clone = (AliveForChoosingPlayer) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	/**
	 * TODO: Information about a player should be described better
	 */
	@Override
	public String toString() {
		return this.getName() + ": " + this.getScore();
	}

	private final void setPlaying() {
		this.setPlayerState(PlayerState.PLAYING);
	}

	private final void setPerformedMove() {
		this.setPlayerState(PlayerState.PERFORMED_MOVE);
	}
}
