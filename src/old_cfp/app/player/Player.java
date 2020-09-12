package app.player;

import gameSession.E2Players;
import gameSession.EMossa;
import player.IPlayer;

public abstract class Player implements IPlayer {
	
	protected String id;
	protected int punteggio;
	protected boolean win;
	protected static final int numPossibleChoices = 3;

	public Player(E2Players p) {
		setID(p.name());
		setPunti(0);
		setWin(false);
	}

	public String getID() {
		return this.id;
	}
	public int getPunti() {
		return this.punteggio;
	}
	public boolean getWin() {
		return this.win;
	}

	public void setID(String s) {
		this.id = s;
	}
	public void setPunti(int p) {
		this.punteggio = p;
	}
	public void setWin(boolean w) {
		this.win = w;
	}
	
	public abstract EMossa chooseMove();

	public void updatePunti() {
		this.punteggio += 1;
	}
	
	public void checkPlayerWinningStatus(int winPoints){
		setWin(getPunti() >= winPoints);
	}
}
