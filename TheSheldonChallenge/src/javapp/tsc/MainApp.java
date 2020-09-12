/**
 * 
 */
package javapp.tsc;

import javapp.tsc.core.GUICore;
import javapp.tsc.gameSession.impl.IRegularGS;
import javapp.tsc.gameSession.impl.regular.RoundBasedGS;
import javapp.tsc.player.impl.AliveForChoosingPlayer;
import javapp.tsc.player.impl.AI.RandomPlayer;
import javapp.tsc.player.impl.human.ConsolePlayer;
import javapp.tsc.util.optionManager.file.xml.SAXOptionManager;
import core.tsc.AppCore;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
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
		// startGameSession();
	}

	private final static void startGame() {
		AppCore.getInstance().initializeGameData(new SAXOptionManager());
		GUICore.getInstance().initializeGUIData();
		GUICore.startGUI();
	}

	@SuppressWarnings("unused")
	private final static void startConsoleGame() {

		AliveForChoosingPlayer p1 = null;
		AliveForChoosingPlayer p2 = null;
		Rule r = AppCore.getInstance().getSessionRule();

		try {
			p1 = new ConsolePlayer("Player", r);
			p2 = new RandomPlayer("AI", r);
		} catch (NoPlayerNameException e) {
			e.printStackTrace();
		} catch (UnknownRuleException e) {
			e.printStackTrace();
		}

		IRegularGS gs = null;
		gs = new RoundBasedGS(p1, p2);

		new Thread(gs, "GAME SESSION").start();

	}

}
