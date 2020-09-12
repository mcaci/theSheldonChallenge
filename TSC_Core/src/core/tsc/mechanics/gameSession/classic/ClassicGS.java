package core.tsc.mechanics.gameSession.classic;

import core.tsc.ipc.IHook;
import core.tsc.ipc.IntercomCore;
import core.tsc.player.IPlayer;
import core.tsc.player.exception.PlayerNotReadyException;
import core.tsc.player.util.InGameStatus;
import core.tsc.player.util.PlayerStatus;

/**
 * Game session featuring two players and the ending condition is reaching a winning
 * @author nikiforos
 *
 */
public abstract class ClassicGS implements IClassicGS {

	private IPlayer p1;
	private IPlayer p2;
	private int winScore;
	private int currentRound;

	private IHook labelUpdater = null;

	protected ClassicGS() {
		this.initializeFields(null, null, 0);
	}
	
	protected ClassicGS(IPlayer p1, IPlayer p2) {
		this.initializeFields(p1, p2, DEFAULT_WIN_SCORE);
	}
	
	protected ClassicGS(IPlayer p1, IPlayer p2, int winScore) {
		this.initializeFields(p1, p2, winScore);
	}

	@Override
	public abstract void run();

	private final void initializeFields(IPlayer p1, IPlayer p2, int winScore) {
		this.setP1(p1);
		this.setP2(p2);
		this.setWinScore(winScore);
		this.setCurrentRound(0);
		this.registerToHook(IntercomCore.getInstance().getHook());
	}
	
	@Override
	public final boolean checkIfGameWinner(IPlayer p) {
		return p.getScore() >= this.getWinScore();
	}

	protected static final boolean isPlayerReadToPlay(IPlayer p)
			throws PlayerNotReadyException {
		boolean flag = true;

		// TODO: useful again?
//		flag &= (p.getMove() == null);
		flag &= (p.getPlayerState().equals(InGameStatus.READY_TO_PLAY));
		flag &= (p.getPlayerStatus().equals(PlayerStatus.NOT_A_WINNER));

		if (!flag) {
			throw new PlayerNotReadyException();
		}
		return flag;
	}
	
	protected final void printInfo(){
		System.out.println("Round #" + this.getCurrentRound());
		System.out.println(this.getP1().toString());
		System.out.println(this.getP2().toString());
		System.out.println();
	}
	
	@Override
	public boolean isGameOver() {
		if(this.getCurrentRound() == 0) return false;
		
		boolean exitFlag = false;
		exitFlag |= this.getP1().getPlayerStatus().isGameWinner();
		exitFlag |= this.getP2().getPlayerStatus().isGameWinner();
		if(exitFlag) return true;
		
		return false;
		
		// TODO: add info about Thread.isInterrupted()... very important
	}
	
	protected static final boolean checkSurrender() {
		return Thread.currentThread().isInterrupted();
	}
	
	protected abstract void registerToHook(IHook hook);

	// -------------- GETTERS AND SETTERS ------------- //
	
	protected final void setP1(IPlayer p1) {
		this.p1 = p1;
	}

	public final IPlayer getP1() {
		return p1;
	}

	protected final void setP2(IPlayer p2) {
		this.p2 = p2;
	}

	public final IPlayer getP2() {
		return p2;
	}

	protected final void setWinScore(int winScore) {
		this.winScore = winScore;
	}

	public final int getWinScore() {
		return winScore;
	}

	protected final void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public final int getCurrentRound() {
		return currentRound;
	}

	protected final IHook getLabelUpdater() {
		return labelUpdater;
	}

	protected final void setLabelUpdater(IHook labelUpdater) {
		this.labelUpdater = labelUpdater;
	}
}
