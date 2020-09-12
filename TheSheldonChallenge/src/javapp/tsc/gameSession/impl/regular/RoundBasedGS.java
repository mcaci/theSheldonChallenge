/**
 * 
 */
package javapp.tsc.gameSession.impl.regular;

import javapp.tsc.gameRound.impl.regular.ParallelGSBasedGR;
import javapp.tsc.gameSession.exception.PlayerNotReadyException;
import javapp.tsc.player.impl.AliveForChoosingPlayer;
import core.tsc.player.UpdateContext;
import core.tsc.player.exception.UnsuccessfulUpdateException;

/**
 * @author nikiforos
 * 
 */
public final class RoundBasedGS extends RegularGS {

	/**
	 * Each concrete implementation of a GameSession needs to provide the two
	 * players and the ruleSet
	 */
	public RoundBasedGS(AliveForChoosingPlayer p1, AliveForChoosingPlayer p2) {
		super();
		this.initializeFields(p1, p2, DEFAULT_WIN_SCORE);
	}

	/**
	 * Full constructor
	 */
	public RoundBasedGS(AliveForChoosingPlayer p1, AliveForChoosingPlayer p2,
			int winScore) {
		super();
		this.initializeFields(p1, p2, winScore);
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
		// boolean exitFlag = checkExitCondition();
		boolean exitFlag = false;

		while (!(exitFlag || Thread.interrupted())) {

			boolean readyFlag = false;
			try {
				readyFlag = checkBeforeNewRound();
			} catch (PlayerNotReadyException e) {
				e.printStackTrace();
			}

			// synchronizing with players if they're not ready (for now it's a
			// busy waiting (TODO: change))
			if (readyFlag) {
				// PHASE 3: execute a round (choices and resolution)
				ParallelGSBasedGR gr = new ParallelGSBasedGR(this);
//				ParallelGR gr = new ParallelGR(this);
				gr.run();

				// got a winner here maybe
				// TODO: to be moved down
				if (Thread.currentThread().isInterrupted()) {
					return;
				}

				// TODO: here everyone should be in the PERFORMED_MOVE state,
				// players have the roundwinner flag already modified
				// (checked but to ensure once and for all)

				// PHASE 4: update players
				try {
					this.updateEveryone();
				} catch (UnsuccessfulUpdateException e) {
					e.printStackTrace();
				}

				// PHASE 4.1: notify mediator (update GUI)
				this.getGuiCommunicator().updateScoreLabels();

				// this.printInfo();
				System.out.println(this.getP1().toString());
				System.out.println(this.getP2().toString());

				// PHASE 5: control of the situation after the round
				exitFlag = checkExitCondition();
			} else {
				// TODO: synchro with player readiness
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
		exitPlayerFromGame(this.getP1());
		exitPlayerFromGame(this.getP2());

		// Go to end panel
		this.getGuiCommunicator().endGame();
	}

	private final void updateEveryone() throws UnsuccessfulUpdateException {
		this.getP1().updateInfo(UpdateContext.END_OF_ROUND);
		this.getP2().updateInfo(UpdateContext.END_OF_ROUND);
	}

	/**
	 * true or exception
	 * 
	 * @return
	 * @throws PlayerNotReadyException
	 */
	private final boolean checkBeforeNewRound() throws PlayerNotReadyException {
		return isPlayerReadToPlay(this.getP1())
				&& isPlayerReadToPlay(this.getP2());
	}

	private final boolean checkExitCondition() {
		boolean exitFlag = false;
		exitFlag |= this.getP1().getPlayerStatus().isGameWinner();
		exitFlag |= this.getP2().getPlayerStatus().isGameWinner();
		return exitFlag;
	}

}
