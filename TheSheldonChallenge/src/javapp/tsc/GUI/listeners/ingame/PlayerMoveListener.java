package javapp.tsc.GUI.listeners.ingame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.EndGamePanel;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.GUI.panels.components.buttons.halfSized.RandomButton;
import javapp.tsc.GUI.panels.components.buttons.halfSized.SurrenderButton;
import javapp.tsc.GUI.panels.components.choicePanel.ChooserButton;
import javapp.tsc.core.IntercomCore;
import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.OtherMessage;
import javapp.tsc.mediation.playerGUI.PlayerGUIMediator;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.player.impl.basic.DummyPlayer;
import core.tsc.rule.ruleSet.IRuleSet;

public final class PlayerMoveListener extends PanelStateTransitionListener {

	private PlayerGUIMediator guiP1Communicator;

	@SuppressWarnings("unused")
	private PlayerGUIMediator guiP2Communicator;

	public PlayerMoveListener(InGamePanel self) {
		super(self, self.getPanelState());

		this.guiP1Communicator = IntercomCore.getInstance().getP1Com();
		this.guiP1Communicator.registerInGamePanel(this);

		// TODO: to change when introducing second human player
		// this.guiP2Communicator = IntercomCore.getInstance().getP2Com();
		// this.guiP2Communicator.registerInGamePanel(this);
	}

	public PlayerMoveListener(InGamePanel self, PanelState next) {
		super(self, next);

		this.guiP1Communicator = IntercomCore.getInstance().getP1Com();
		this.guiP1Communicator.registerInGamePanel(this);

		// TODO: to change when introducing second human player
		// this.guiP2Communicator = IntercomCore.getInstance().getP2Com();
		// this.guiP2Communicator.registerInGamePanel(this);
	}

	/**
	 * TODO: works only with one player
	 */
	@Override
	public final void actionPerformed(ActionEvent arg0) {

		final InGamePanel igp = (InGamePanel) previousPanel;

		super.actionPerformed(arg0);

		if (arg0.getSource() instanceof ChooserButton) {
			IRuleSet move = ((ChooserButton) (arg0.getSource()))
					.getCorrespondingMove();
			igp.setMoveToReturn(move);
		} else if (arg0.getSource() instanceof RandomButton) {
			IRuleSet move = DummyPlayer.chooseRandomMove(AppCore.getInstance()
					.getSessionRule());
			igp.setMoveToReturn(move);
		} else if (arg0.getSource() instanceof SurrenderButton) {
			// the surrender mark
			igp.setMoveToReturn(null);

			// set strings for printing outcome
			final String sP1 = igp.getPlayer1Label().getText() + ": "
					+ igp.getScore1Label().getText() + "\n";
			final String sP2 = igp.getPlayer2Label().getText() + ": "
					+ igp.getScore2Label().getText() + "\n";

			// TODO: to change to determine who surrendered
			final String sWin = igp.getPlayer2Label().getText();

			EndGamePanel tmp = (EndGamePanel) this.nextPanel;
			Language currentLang = AppCore.getInstance().getSessionLanguage();
			tmp.loadExpressionPath("./src/javapp/tsc/img/sheldon/expr/loss/disapp.jpg");
			tmp.getOutcomeTextArea()
					.getTextArea()
					.setText(
							sP1
									+ sP2
									+ sWin
									+ " "
									+ new XMLFileTranslator().translate(
											OtherMessage.FORFEIT, currentLang));
		} else {
			// TODO: exception???
		}

		this.guiP1Communicator.notifyPlayer();
	}

}