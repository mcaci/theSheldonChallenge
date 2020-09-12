package javapp.tsc.GUI.listeners.newgame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.GUI.panels.InputPlayersPanel;
import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.state.PanelState;
import javapp.tsc.mechanics.gameSession.RB_Auto_GS;
import javapp.tsc.mechanics.gameSession.RB_GUI_1P_GS;
import javapp.tsc.mechanics.gameSession.RB_GUI_2P_GS;
import javapp.tsc.player.impl.human.SwingPlayer;
import core.tsc.AppCore;
import core.tsc.mechanics.GameType;
import core.tsc.mechanics.gameSession.IGameSession;
import core.tsc.player.IPlayer;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.afc.RandomPlayer;
import core.tsc.rule.Rule;

public abstract class StartGameListener extends PanelStateTransitionListener {

	public StartGameListener(final BasePanel prevPanel, final PanelState nextPanelState) {
		super(prevPanel, nextPanelState);
	}
	
	@Override
	public void actionPerformed(final ActionEvent arg0) {
		
		if(this.previousPanel instanceof InputPlayersPanel){
			final InputPlayersPanel ipw = (InputPlayersPanel) previousPanel;

			final String s1 = ipw.getNameP1TextField().getText();
			final String s2 = ipw.getNameP2TextField().getText();

			AppCore.getInstance().getData().setPlayerNames(s1, s2);
			
			System.out.println(s1 + " vs " + s2);
		}

		final GameType gt = AppCore.getInstance().getGameType();
		final Rule r = AppCore.getInstance().getSessionRule();
		final int maxScore = AppCore.getInstance().getScoreToWin();
		final String s1 = AppCore.getInstance().getNameP1();
		final String s2 = AppCore.getInstance().getNameP2();
		
		IPlayer p1 = null;
		IPlayer p2 = null;
		IGameSession gs = null;
		
		try {
			switch (gt) {
			case AI_VS_AI:
				p1 = new RandomPlayer(s1, r);
				p2 = new RandomPlayer(s2, r);
				gs = new RB_Auto_GS((RandomPlayer) p1, (RandomPlayer) p2, maxScore);
				break;
			case PLAYER_VS_AI:
				p1 = new SwingPlayer(s1, r);
				p2 = new RandomPlayer(s2, r);
				gs = new RB_GUI_1P_GS((SwingPlayer) p1, (RandomPlayer) p2, maxScore);
				break;
			case PLAYER_VS_PLAYER:
				p1 = new SwingPlayer(s1, r);
				p2 = new SwingPlayer(s2, r);
				gs = new RB_GUI_2P_GS((SwingPlayer) p1, (SwingPlayer) p2, maxScore);
				break;
			default:
				break;
			}

		} catch (NoPlayerNameException e) {
			e.printStackTrace();
		} catch (UnknownRuleException e) {
			e.printStackTrace();
		}

		// prepare new panel and switch
		super.actionPerformed(arg0);
		
		final InGamePanel tmp = (InGamePanel) this.nextPanel;
		if(this.previousPanel instanceof InputPlayersPanel){
			tmp.getPlayer1Label().setText(p1.getName());
			tmp.getPlayer2Label().setText(p2.getName());
		}
		GUICore.getInstance().setIgp(tmp);

		// start game
		AppCore.getInstance().startNewGame(gs);
	}

}
