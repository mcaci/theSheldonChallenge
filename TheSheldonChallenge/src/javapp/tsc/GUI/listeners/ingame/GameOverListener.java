/**
 * 
 */
package javapp.tsc.GUI.listeners.ingame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.EndGamePanel;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.ipc.com.SwingLabelHook;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.lang.vocab.OtherMessage;

/**
 * @author nikiforos
 * 
 */
public final class GameOverListener extends PanelStateTransitionListener {

	private SwingLabelHook winUpdater;

	/**
	 * @param p
	 * @param n
	 */
	public GameOverListener(InGamePanel prev, PanelState next) {
		super(prev, next);
	}

	@Override
	public final void actionPerformed(ActionEvent arg0) {
		// set strings for printing outcome
		InGamePanel igp = (InGamePanel) previousPanel;

		String label1 = igp.getPlayer1Label().getText();
		String label2 = igp.getPlayer2Label().getText();

		int score1 = Integer.parseInt(igp.getScore1Label().getText());
		int score2 = Integer.parseInt(igp.getScore2Label().getText());

		String sP1 = label1 + ": " + score1 + "\n";
		String sP2 = label2 + ": " + score2 + "\n";

		String sWin = (score1 > score2 ? label1 : label2);

		super.actionPerformed(arg0);

		EndGamePanel tmp = (EndGamePanel) this.nextPanel;
		Language currentLang = AppCore.getInstance().getSessionLanguage();
		if (score1 > score2) {
			tmp.loadExpressionPath("./src/javapp/tsc/img/sheldon/expr/win/smile.jpg");
		} else {
			tmp.loadExpressionPath("./src/javapp/tsc/img/sheldon/expr/loss/sad.jpg");
		}
		tmp.getOutcomeTextArea()
				.getTextArea()
				.setText(
						sP1
								+ sP2
								+ sWin
								+ " "
								+ new XMLFileTranslator().translate(
										OtherMessage.END_GAME, currentLang));
	}

	public final SwingLabelHook getWinUpdater() {
		return winUpdater;
	}

	public final void setWinUpdater(SwingLabelHook winUpdater) {
		this.winUpdater = winUpdater;
	}

}