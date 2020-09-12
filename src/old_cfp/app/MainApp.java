package app;

import app.gameSession.GameSession;
import app.gameSession.AIvsAI_GS.AIvsAI_GS;

public class MainApp {
	
	public static void main(String[] args) throws Exception {
		
		GameSession gs = new AIvsAI_GS(100);
		gs.startGame();
		
//		for(int i = 0; i < 500; i++){
//			GameSession gs = new AIvsAI_GS(100);
//			gs.startGame();
//			MySQLdbResultsWriter out = new MySQLdbResultsWriter();
//			out.writeResults(gs);
//		}
	}
}