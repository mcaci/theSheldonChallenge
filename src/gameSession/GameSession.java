package gameSession;

import interfaces.IGameSession;
import player.Player;

/**
 * @author nikiforos
 *
 */
public abstract class GameSession implements IGameSession {

	private static int WIN_SCORE = 3;
	
	/**
	 * 
	 */
	public GameSession() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean checkGameWinner(Player p){
		return checkGameWinner(p.getPoints());
	}
	
	public static boolean checkGameWinner(int player_score){
		if(player_score >= WIN_SCORE){
			return true;
		}
		else{
			return false;
		}
	}

}
