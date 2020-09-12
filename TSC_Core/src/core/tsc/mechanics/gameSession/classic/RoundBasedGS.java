/**
 * 
 */
package core.tsc.mechanics.gameSession.classic;

import core.tsc.ipc.communication.Context;
import core.tsc.mechanics.gameRound.IGameRound;
import core.tsc.mechanics.gameRound.ParallelGSBasedGR;
import core.tsc.player.IPlayer;
import core.tsc.player.exception.PlayerNotReadyException;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.util.InGameStatus;

/**
 * @author nikiforos
 * 
 */
public abstract class RoundBasedGS extends ClassicGS {

	/**
	 * Each concrete implementation of a GameSession needs to provide the two
	 * players and the ruleSet
	 */
	public RoundBasedGS(IPlayer p1, IPlayer p2) {
		super(p1, p2);
	}

	/**
	 * Full constructor
	 */
	public RoundBasedGS(IPlayer p1, IPlayer p2, int winScore) {
		super(p1, p2, winScore);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gameSession.IGameSession#startGame()
	 */
	@Override
	public final void run() {

		// PHASE 2: control of the situation (first exit flag and start round
		// conditions)
		boolean exitFlag = isGameOver();
		while (!exitFlag) {

			// CHECKING IF PLAYER IS READY
			// at this point both players are at the READY_TO_PLAY state
			boolean readyFlag = false;
			try {
				readyFlag = checkBeforeNewRound();
			} catch (PlayerNotReadyException e) {
				e.printStackTrace();
			}

			// TODO: synchronizing with players if they're not ready?
			if (readyFlag) {
				// PHASE 3: EXECUTE A ROUND (TAKE CHOICES AND ROUND RESOLUTION)
				final IGameRound gr = new ParallelGSBasedGR(this);
				this.setCurrentRound(gr.getRoundNumber());
				gr.run();
				// at this point both players are at the PERFORMED_MOVE state
				// and they both have MOVE and STATUS UPDATED

				// AFTER ROUND WE CHECK IF SOMEONE SURRENDERED
				if (checkSurrender()) return;

				// here everyone is in the PERFORMED_MOVE state,
				// players have the round winner flag already modified

				// PHASE 4: UPDATE PLAYERS
				try {
					this.updateEveryone();
				} catch (UnsuccessfulUpdateException e) {
					e.printStackTrace();
				}
				// at this point both players are at the UPDATING state
				// and they both have the SCORE UPDATED

				// PHASE 4.1: UPDATE UI
				this.getLabelUpdater().updateUI(Context.LABEL);
				this.getLabelUpdater().updateUI(Context.SCORE);

				// TODO: to remove or comment
				 this.printInfo();
				
				// PHASE 5: control of the situation after at the end of the round
				 exitFlag = isGameOver();
				 endRound(exitFlag);
			} else {
				// TODO: synchro with players or quit
			}
		}

		// PHASE 6: exit the game
		try {
			this.prepareForExit();
		} catch (UnsuccessfulUpdateException e) {
			e.printStackTrace();
		}
	}

	private final void prepareForExit() throws UnsuccessfulUpdateException {
		this.getP1().exitFromGame();
		this.getP2().exitFromGame();

		// Go to end panel
		this.getLabelUpdater().updateUI(Context.END);
		
		// free resources for players
		this.setP1(null);
		this.setP2(null);
	}

	private final void updateEveryone() throws UnsuccessfulUpdateException {
		// update scores and status roundWinners
		this.getP1().updateScore();
		this.getP2().updateScore();
			
		this.getP1().updateInfo(this);
		this.getP2().updateInfo(this);
	}

	/**
	 * true or exception
	 * 
	 * @return
	 * @throws PlayerNotReadyException
	 */
	private final boolean checkBeforeNewRound() throws PlayerNotReadyException {
		return isPlayerReadToPlay(this.getP1()) && isPlayerReadToPlay(this.getP2());
	}

	private final void endRound(boolean exitFlag) {
		
		if(exitFlag){
			this.getP1().setPlayerState(InGameStatus.READY_TO_EXIT);
			this.getP2().setPlayerState(InGameStatus.READY_TO_EXIT);
		}
		else{
			// updates to do anyway
			// this.setMove(null); (reeeeally?)
			this.getP1().setPlayerState(InGameStatus.READY_TO_PLAY);
			this.getP2().setPlayerState(InGameStatus.READY_TO_PLAY);
		}
	}

}
