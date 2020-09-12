/**
 * 
 */
package javapp.tsc.GUI.listeners.newgame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.GUI.panels.InputPlayersPanel;
import javapp.tsc.mechanics.gameSession.roundBased.RB_GUI_GS;
import javapp.tsc.player.impl.human.SwingPlayer;
import core.tsc.AppCore;
import core.tsc.mechanics.gameSession.IGameSession;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.afc.RandomPlayer;
import core.tsc.rule.Rule;

/**
 * @author nikiforos
 * 
 */
public final class GoButtonActionListener extends PanelStateTransitionListener {

	/**
	 * 
	 */
	public GoButtonActionListener(InputPlayersPanel self) {
		super(self, PanelState.IN_GAME);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public final void actionPerformed(ActionEvent arg0) {
		// set input for game session
		InputPlayersPanel ipw = (InputPlayersPanel) previousPanel;

		String s1 = ipw.getNameP1TextField().getText();
		String s2 = ipw.getNameP2TextField().getText();

		AppCore.getInstance().getData().setPlayerNames(s1, s2);

		System.out.println(s1 + " vs " + s2);

		SwingPlayer p1 = null;
		RandomPlayer p2 = null;
		Rule r = AppCore.getInstance().getSessionRule();

		try {
			p1 = new SwingPlayer(AppCore.getInstance().getNameP1(), r);
			// p1 = new RandomPlayer(AppCore.getInstance().getNameP1(), r);
			p2 = new RandomPlayer(AppCore.getInstance().getNameP2(), r);
		} catch (NoPlayerNameException e) {
			e.printStackTrace();
		} catch (UnknownRuleException e) {
			e.printStackTrace();
		}

		// prepare new panel and switch
		super.actionPerformed(arg0);

		InGamePanel tmp = (InGamePanel) this.nextPanel;
		tmp.getPlayer1Label().setText(p1.getName());
		tmp.getPlayer2Label().setText(p2.getName());
		GUICore.getInstance().setIgp(tmp);

		// start game
		IGameSession gs = null;
		gs = new RB_GUI_GS(p1, p2, AppCore.getInstance().getScoreToWin());

		new Thread(gs, "GAME SESSION").start();
	}

}
