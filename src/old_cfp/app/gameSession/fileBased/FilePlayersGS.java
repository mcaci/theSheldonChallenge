package app.gameSession.fileBased;

import gameSession.E2Players;
import app.gameSession.GameSession;
import app.player.FilePlayer;

public class FilePlayersGS extends GameSession {

	public FilePlayersGS() {
		super(new FilePlayer(E2Players.PLAYER1),
				new FilePlayer(E2Players.PLAYER2)
		);
	}
	
	public FilePlayersGS(int ws) {
		super(new FilePlayer(E2Players.PLAYER1),
				new FilePlayer(E2Players.PLAYER2),
				ws
		);
	}

}
