package player;

import gameSession.EMossa;

public abstract interface IPlayer {
	
  public abstract EMossa chooseMove();

  public abstract void updatePunti();
}