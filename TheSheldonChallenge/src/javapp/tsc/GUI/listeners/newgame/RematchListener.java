package javapp.tsc.GUI.listeners.newgame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.EndGamePanel;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.mechanics.gameSession.roundBased.RB_GUI_GS;
import javapp.tsc.player.impl.human.SwingPlayer;
import core.tsc.AppCore;
import core.tsc.mechanics.gameSession.IGameSession;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.afc.RandomPlayer;
import core.tsc.rule.Rule;

//TODO: very similar to the GoButtonActionListener!!!
public final class RematchListener extends PanelStateTransitionListener {

	public RematchListener(EndGamePanel self) {
		super(self, PanelState.IN_GAME);
	}

	@Override
	public final void actionPerformed(ActionEvent arg0) {

		SwingPlayer p1 = null;
		RandomPlayer p2 = null;
		Rule r = AppCore.getInstance().getSessionRule();

		try {
			p1 = new SwingPlayer(AppCore.getInstance().getNameP1(), r);
			p2 = new RandomPlayer(AppCore.getInstance().getNameP2(), r);
		} catch (NoPlayerNameException e) {
			e.printStackTrace();
		} catch (UnknownRuleException e) {
			e.printStackTrace();
		}

		// TODO: start new game
		super.actionPerformed(arg0);
		GUICore.getInstance().setIgp((InGamePanel) this.nextPanel);

		// start game
		IGameSession gs = null;
		gs = new RB_GUI_GS(p1, p2, AppCore.getInstance().getScoreToWin());

		new Thread(gs, "GAME SESSION").start();
	}

}
