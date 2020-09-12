package app.gameSession;

import app.player.Player;
import gameSession.E2Players;
import gameSession.EMossa;
import gameSession.IGameSession;

public class GameSession implements IGameSession {
	
	protected Player p1;
	protected Player p2;
	protected boolean hasEnded;
	protected int winScore;
	
	private static final int DEFAULT_WINSCORE = 3;
	
	public GameSession(Player pl1, Player pl2) {
		this.parametersInit(pl1, pl2, false, DEFAULT_WINSCORE);
	}
	
	public GameSession(Player pl1, Player pl2, int ws) {
		this.parametersInit(pl1, pl2, false, ws);
	}
	
	protected void parametersInit(Player pl1, Player pl2, boolean he, int ws){
		this.setP1(pl1);
		this.setP2(pl2);
		this.setHasEnded(he);
		this.setWinScore(ws);
	}
	
	@Override
	public void run() {
		startGame();
	}
	
	public void startGame(){
		E2Players roundWinner = null;
		while (!this.itHasEnded()) {
			
			// round run
			EMossa sceltaP1 = this.getP1().chooseMove();
			EMossa sceltaP2 = this.getP2().chooseMove();
			roundWinner = this.getOutcome(sceltaP1, sceltaP2);
			updateScoreAndStatus(roundWinner);

			// round information
			System.out.println(sceltaP1.name() + " " + sceltaP2.name());
			System.out.print(this.getP1().getID() + ": " + this.getP1().getPunti() + " - ");
			System.out.println(this.getP2().getID() + ": " + this.getP2().getPunti());
			System.out.println();
		}
		System.out.println(getWinner().getID() + " wins.");
	}

	public Player getWinner() {
		if (this.getP1().getWin()) {
			return this.getP1();
		}
		else {
			return this.getP2();
		}
	}

	/**
	 * 
	 */
	public void updateScoreAndStatus(E2Players roundWinner) {
		if (roundWinner != null)
			switch (roundWinner) {
			case PLAYER1:
				this.getP1().updatePunti();
				this.getP1().checkPlayerWinningStatus(getWinScore());
				this.setHasEnded(this.getP1().getWin());
				break;
			case PLAYER2:
				this.getP2().updatePunti();
				this.getP2().checkPlayerWinningStatus(getWinScore());
				this.setHasEnded(this.getP2().getWin());
				break;
			}
	}

	/**
	 * @return the player that wins the round
	 */
	public E2Players getOutcome(EMossa p1Move, EMossa p2Move)
	{
		if (p1Move.ordinal() == p2Move.ordinal()) {
			return null;
		}
		if (p1Move.ordinal() == (p2Move.ordinal() + 1) % EMossa.values().length) {
			return E2Players.PLAYER1;
		}

		return E2Players.PLAYER2;
	}

	/**
	 * @return the p1
	 */
	public Player getP1() {
		return p1;
	}

	/**
	 * @param p1 the p1 to set
	 */
	protected void setP1(Player p1) {
		this.p1 = p1;
	}

	/**
	 * @return the p2
	 */
	public Player getP2() {
		return p2;
	}

	/**
	 * @param p2 the p2 to set
	 */
	protected void setP2(Player p2) {
		this.p2 = p2;
	}

	/**
	 * @return the hasEnded
	 */
	protected boolean itHasEnded() {
		return hasEnded;
	}

	/**
	 * @param hasEnded the hasEnded to set
	 */
	protected void setHasEnded(boolean hasEnded) {
		this.hasEnded = hasEnded;
	}
	
	/**
	 * @return the winScore
	 */
	protected void setWinScore(int winScore) {
		this.winScore = winScore;
	}

	/**
	 * @return the winScore
	 */
	protected int getWinScore() {
		return winScore;
	}

}

