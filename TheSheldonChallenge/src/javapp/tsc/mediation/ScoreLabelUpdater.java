/**
 * 
 */
package javapp.tsc.mediation;

import javapp.tsc.GUI.listeners.ingame.GameOverListener;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.gameSession.impl.IRegularGS;

/**
 * MEDIATOR PATTERN: Concrete Mediator Works with the 2 player version ONLY
 * 
 * @author nikiforos
 * 
 */
public class ScoreLabelUpdater {

	private InGamePanel igp;
	private IRegularGS gs;
	private GameOverListener gol;

	public ScoreLabelUpdater() {
		this.igp = null;
		this.gs = null;
		this.gol = null;
	}

	public final void updateScoreLabels() {
		String score1 = Integer.toString(this.gs.getP1().getScore());
		String score2 = Integer.toString(this.gs.getP2().getScore());

		this.igp.getScore1Label().setText(score1);
		this.igp.getScore2Label().setText(score2);
	}

	public final void endGame() {
		gol.actionPerformed(null);
	}

	public final void registerInGamePanel(InGamePanel igp) {
		this.igp = igp;
	}

	public final void registerGameSession(IRegularGS gs) {
		this.gs = gs;
	}

	public final void registerGameOverListener(GameOverListener gol) {
		this.gol = gol;
	}

	public final InGamePanel getIgp() {
		return igp;
	}

	public final IRegularGS getGs() {
		return gs;
	}

	public final GameOverListener getGol() {
		return gol;
	}

}
