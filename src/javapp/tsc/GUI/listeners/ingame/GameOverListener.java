/**
 * 
 */
package javapp.tsc.GUI.listeners.ingame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.EndGamePanel;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.GUI.panels.state.PanelState;
import javapp.tsc.ipc.com.SwingLabelHook;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.OtherMessage;
import core.tsc.util.PathManager;

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
	public GameOverListener(final InGamePanel prev, final PanelState next) {
		super(prev, next);
	}

	@Override
	public final void actionPerformed(final ActionEvent arg0) {
		// set strings for printing outcome
		final InGamePanel igp = (InGamePanel) previousPanel;

		final String label1 = igp.getPlayer1Label().getText();
		final String label2 = igp.getPlayer2Label().getText();

		final int score1 = Integer.parseInt(igp.getScore1Label().getText());
		final int score2 = Integer.parseInt(igp.getScore2Label().getText());

		final String sP1 = label1 + ": " + score1 + "\n";
		final String sP2 = label2 + ": " + score2 + "\n";

		final String move1 = igp.getMove1Label().getText();
		final String move2 = igp.getMove2Label().getText();
		final boolean surrendered1 = (move1.equals("-") ? true : false);
		final boolean surrendered2 = (move2.equals("-") ? true : false);

		String sWin = surrenderedPlayer(label1, label2, surrendered1, surrendered2);
		if(sWin == null){
			sWin = (score1 > score2 ? label1 : label2);
		}

		super.actionPerformed(arg0);

		final EndGamePanel tmp = (EndGamePanel) this.nextPanel;
		final Language currentLang = AppCore.getInstance().getSessionLanguage();
		String imagePath = PathManager.getFullDir(new String[] {
				PathManager.getCurrentPath(), "src", "javapp", "tsc", "img", "sheldon", "expr"});
		OtherMessage messageToPrint = OtherMessage.FORFEIT;
		if(surrendered1){
			imagePath += "loss/disapp.jpg";
		} else if(surrendered2){
			imagePath += "win/smile.jpg";
		} else {
			messageToPrint = OtherMessage.END_GAME;
			if (score1 > score2) {
				imagePath += "win/smile.jpg";
			} else {
				imagePath += "loss/sad.jpg";
			}
		}
		tmp.loadExpressionPath(imagePath);
		tmp.getOutcomeTextArea()
				.getTextArea()
				.setText(
						sP1
								+ sP2
								+ sWin
								+ " "
								+ new XMLTranslator().translate(messageToPrint, currentLang));
	}
	
	private final String surrenderedPlayer(
			String name1, String name2,
			boolean surrendered1, boolean surrendered2){

		if(surrendered1){
			return name2;
		}
		else if(surrendered2){
			return name1;
		}
		else{
			return null;
		}
	}

	public final SwingLabelHook getWinUpdater() {
		return winUpdater;
	}

	public final void setWinUpdater(final SwingLabelHook winUpdater) {
		this.winUpdater = winUpdater;
	}

}