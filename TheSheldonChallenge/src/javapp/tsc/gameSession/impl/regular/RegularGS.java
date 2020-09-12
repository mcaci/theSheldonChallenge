package javapp.tsc.gameSession.impl.regular;

import javapp.tsc.core.IntercomCore;
import javapp.tsc.gameSession.exception.PlayerNotReadyException;
import javapp.tsc.gameSession.impl.IRegularGS;
import javapp.tsc.mediation.ScoreLabelUpdater;
import javapp.tsc.player.impl.AliveForChoosingPlayer;
import core.tsc.AppCore;
import core.tsc.player.IPlayer;
import core.tsc.player.UpdateContext;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.impl.basic.BasicPlayer;
import core.tsc.player.util.PlayerState;
import core.tsc.player.util.PlayerStatus;

abstract class RegularGS implements IRegularGS {

	private IPlayer p1;
	private IPlayer p2;

	private int winScore;

	/**
	 * TODO: Just for info??
	 */
	private int currentRound;

	private ScoreLabelUpdater guiCommunicator;

	public RegularGS() {
		this.initializeFields(null, null, 0);

		this.guiCommunicator = IntercomCore.getInstance().getGsCom();
		this.guiCommunicator.registerGameSession(this);
	}

	@Override
	public abstract void run();

	protected final void initializeFields(AliveForChoosingPlayer p1,
			AliveForChoosingPlayer p2, int winScore) {
		this.setP1(p1);
		this.setP2(p2);
		this.setWinScore(winScore);
		this.setCurrentRound(0);
	}

	public final static PlayerStatus checkGameWinner(BasicPlayer p) {
		// TODO: to remove the use of core if possible
		return (checkGameWinner(p.getScore(), AppCore.getInstance()
				.getScoreToWin()) ? PlayerStatus.GAME_WINNER
				: PlayerStatus.NOT_A_WINNER);
	}

	public final static boolean checkGameWinner(int player_score, int win_score) {
		return player_score >= win_score;
	}

	/**
	 * 
	 */
	protected static final boolean isPlayerReadToPlay(IPlayer p)
			throws PlayerNotReadyException {
		boolean flag = true;

		flag &= (p.getMove() == null);
		flag &= (p.getPlayerState().equals(PlayerState.READY_TO_PLAY));
		flag &= (p.getPlayerStatus().equals(PlayerStatus.NOT_A_WINNER));

		if (!flag) {
			throw new PlayerNotReadyException();
		}
		return flag;
	}

	/**
	 * @throws UnsuccessfulUpdateException
	 */
	protected static final void exitPlayerFromGame(IPlayer p)
			throws UnsuccessfulUpdateException {
		p.updateInfo(UpdateContext.END_OF_GAME);
	}

	/**
	 * @param p1
	 *            the p1 to set
	 */
	protected final void setP1(IPlayer p1) {
		this.p1 = p1;
	}

	/**
	 * @return the p1
	 */
	public final IPlayer getP1() {
		return p1;
	}

	/**
	 * @param p2
	 *            the p2 to set
	 */
	protected final void setP2(IPlayer p2) {
		this.p2 = p2;
	}

	/**
	 * @return the p2
	 */
	public final IPlayer getP2() {
		return p2;
	}

	/**
	 * @return the winScore
	 */
	protected final void setWinScore(int winScore) {
		this.winScore = winScore;
	}

	/**
	 * @return the winScore
	 */
	public final int getWinScore() {
		return winScore;
	}

	protected final void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public final int getCurrentRound() {
		return currentRound;
	}

	protected final ScoreLabelUpdater getGuiCommunicator() {
		return guiCommunicator;
	}

	protected final void setGuiCommunicator(ScoreLabelUpdater guiCommunicator) {
		this.guiCommunicator = guiCommunicator;
	}
}
