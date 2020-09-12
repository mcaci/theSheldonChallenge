/**
 * 
 */
package javapp.tsc;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.mechanics.gameSession.roundBased.RB_Console_GS;
import javapp.tsc.player.impl.human.ConsolePlayer;
import core.tsc.AppCore;
import core.tsc.mechanics.gameSession.IGameSession;
import core.tsc.persistency.file.xml.SAXOptionManager;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.afc.RandomPlayer;
import core.tsc.rule.Rule;

/**
 * @author nikiforos
 * 
 */
final class MainApp {

	/**
	 * @param args
	 */
	public final static void main(String[] args) {
		
		startGame();
//		startConsoleGame();
	}

	private final static void startGame() {
		AppCore.getInstance().initializeGameData(new SAXOptionManager());
		GUICore.getInstance().initializeGUIData();
		GUICore.startGUI();
	}

	@SuppressWarnings({ "deprecation", "unused" })
	private final static void startConsoleGame() {

		AppCore.getInstance().initializeGameData();
		ConsolePlayer p1 = null;
		RandomPlayer p2 = null;
		Rule r = Rule.CLASSIC;

		try {
			p1 = new ConsolePlayer("Player", r);
			p2 = new RandomPlayer("AI", r);
		} catch (NoPlayerNameException e) {
			e.printStackTrace();
		} catch (UnknownRuleException e) {
			e.printStackTrace();
		}

		IGameSession gs = null;
		gs = new RB_Console_GS(p1, p2);

		new Thread(gs, "GAME SESSION").start();

	}

}
