package gameSession;

import app.player.Player;

public interface IGameSession extends Runnable {
	
	public void startGame();
	public void updateScoreAndStatus(E2Players roundWinner);
	public E2Players getOutcome(EMossa p1Move, EMossa p2Move);
	public Player getWinner();
	
}
