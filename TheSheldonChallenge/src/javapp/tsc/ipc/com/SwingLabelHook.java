package javapp.tsc.ipc.com;

import javapp.tsc.GUI.listeners.ingame.GameOverListener;
import javapp.tsc.GUI.panels.InGamePanel;
import core.tsc.AppCore;
import core.tsc.ipc.communication.Context;
import core.tsc.ipc.communication.DefaultHook;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.mechanics.gameSession.classic.IClassicGS;
import core.tsc.util.CodingSupport;

public class SwingLabelHook extends DefaultHook {
	
	// GameSession data
	private IClassicGS gs;
	
	// UI data
	private InGamePanel igp;
	private GameOverListener gol;

	public SwingLabelHook() {
		this.igp = null;
		this.gs = null;
		this.gol = null;
	}

	@Override
	public final void updateUI(Context whatToUpdate) {
		super.updateUI(whatToUpdate);
		switch (whatToUpdate) {
		case SCORE:
			final String score1 = Integer.toString(this.gs.getP1().getScore());
			final String score2 = Integer.toString(this.gs.getP2().getScore());

			this.igp.getScore1Label().setText(score1);
			this.igp.getScore2Label().setText(score2);
			break;
		case LABEL:
			final Language currentLang = AppCore.getInstance().getSessionLanguage();
			final String move1 = new XMLFileTranslator().translate(this.gs.getP1()
					.getMove(), currentLang);
			final String move2 = new XMLFileTranslator().translate(this.gs.getP2()
					.getMove(), currentLang);

			this.igp.getMove1Label().setText(move1);
			this.igp.getMove2Label().setText(move2);
			break;
		case END:
			this.gol.actionPerformed(null);
			break;
		default:
			// change to UnexpectedContextException
			CodingSupport.notImplYet();
			break;
		}
	}
	
	public final IClassicGS getGs() {
		return gs;
	}

	public final void setGs(IClassicGS gs) {
		this.gs = gs;
	}

	public final InGamePanel getIgp() {
		return igp;
	}

	public final void setIgp(InGamePanel igp) {
		this.igp = igp;
	}

	public final GameOverListener getGol() {
		return gol;
	}

	public final void setGol(GameOverListener gol) {
		this.gol = gol;
	}

}
