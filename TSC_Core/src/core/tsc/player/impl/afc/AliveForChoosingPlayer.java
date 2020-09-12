/**
 * 
 */
package core.tsc.player.impl.afc;

import core.tsc.mechanics.gameSession.IGameSession;
import core.tsc.player.exception.InvalidStateException;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.impl.DefaultPlayer;
import core.tsc.player.util.InGameStatus;
import core.tsc.player.util.PlayerStatus;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

/**
 * @author nikiforos
 * 
 */
public abstract class AliveForChoosingPlayer extends DefaultPlayer {

//	private PlayerRoundMediator playerMediator;

	/**
	 * 
	 */
	public AliveForChoosingPlayer(String name, Rule ruleUsed)
			throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
//		this.playerMediator = IntercomCore.getInstance().getPGRCom();
	}

	@Override
	public synchronized final void run() {

		while (!Thread.interrupted()) {
			try {
				// wait for prompt from game round
//				this.playerMediator.waitForGameRound();

				// playing state
				this.setPlaying();

				// choose move
				this.setMove(this.chooseMove(this.getRuleUsed()));

				// performed move state
				this.setPerformedMove();

				// interrupt to exit
				Thread.currentThread().interrupt();

				// consistent state check (always helps finding bugs)
				if (!this.getPlayerState().equals(InGameStatus.PERFORMED_MOVE)) {
					throw new InvalidStateException(this.getPlayerState(),
							InGameStatus.PERFORMED_MOVE);
				}

				// notify game round
				this.getNotifier().resume();

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

	@Override
	public final void updateScore() throws UnsuccessfulUpdateException {
		
		this.setPlayerState(InGameStatus.UPDATING);
		
		switch(this.getPlayerStatus()){
		case NOT_A_WINNER:
			break;
		case ROUND_WINNER:
			this.setScore(this.getScore() + 1);
			break;
		default:
			try{
				throw new UnsuccessfulUpdateException();
			} catch(UnsuccessfulUpdateException e){
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see player.IPlayer#updateInfo(boolean)
	 */
	@Override
	public final void updateInfo(IGameSession info)
			throws UnsuccessfulUpdateException {
		
		switch(this.getPlayerStatus()){
		case NOT_A_WINNER:
			break;
		case ROUND_WINNER:
			// and updates player if is the game winner
			if (info.checkIfGameWinner(this)) {
				// if true set exit mode
				this.setPlayerStatus(PlayerStatus.GAME_WINNER);
				this.setPlayerState(InGameStatus.READY_TO_EXIT);
			} else {
				this.setPlayerStatus(PlayerStatus.NOT_A_WINNER);
				// else complete setup to continue (do something?)
			}
			break;
		default:
			try{
				throw new UnsuccessfulUpdateException();
			} catch(UnsuccessfulUpdateException e){
				e.printStackTrace();
			}
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

}
