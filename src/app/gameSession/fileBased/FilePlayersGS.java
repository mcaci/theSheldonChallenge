package app.gameSession.fileBased;

import player.EPlayer;
import app.gameSession.GameSession;
import app.player.FilePlayer;

public class FilePlayersGS extends GameSession {

	public FilePlayersGS() {
		super(new FilePlayer(EPlayer.PLAYER1),
				new FilePlayer(EPlayer.PLAYER2)
		);
	}
	
	public FilePlayersGS(int ws) {
		super(new FilePlayer(EPlayer.PLAYER1),
				new FilePlayer(EPlayer.PLAYER2),
				ws
		);
	}

}
