/**
 * 
 */
package javapp.tsc;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.exception.UnrecognizedOptionException;
import javapp.tsc.mechanics.gameSession.RB_Console_GS;
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
public final class MainApp {

	/**
	 * @param args
	 */
	public final static void main(String[] args) {
		
		boolean startOptionFlag = ( args.length > 0 ? true : false);
		if(startOptionFlag) processArgsAndStart(args[0]);
		else startRegularGame();
	}

	private final static void processArgsAndStart(String startOption) {
		if(startOption.equals("-tsc")) startRegularGame();
		else if(startOption.equals("-cfp")) startConsoleGame();
		else
			try {
				throw new UnrecognizedOptionException();
			} catch (UnrecognizedOptionException e) {
				e.printStackTrace();
			}
	}

	private final static void startRegularGame() {
		AppCore.getInstance().initializeGameData(new SAXOptionManager());
		GUICore.getInstance().initializeGUI().startGUI();
	}

	private final static void startConsoleGame() {

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
