package javapp.tsc.mediation;

import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.gameRound.impl.regular.ParallelGR;
import javapp.tsc.lang.translator.XMLFileTranslator;
import core.tsc.AppCore;
import core.tsc.lang.Language;

public class MoveLabelUpdaterOLD {

	private InGamePanel igp;
	private ParallelGR gr;

	public MoveLabelUpdaterOLD() {
		this.igp = null;
		this.gr = null;
	}

	public final void updateMoveLabels() {
		final Language currentLang = AppCore.getInstance().getSessionLanguage();
		String move1 = new XMLFileTranslator().translate(this.gr.getP1()
				.getMove(), currentLang);
		String move2 = new XMLFileTranslator().translate(this.gr.getP2()
				.getMove(), currentLang);

		this.igp.getMove1Label().setText(move1);
		this.igp.getMove2Label().setText(move2);
	}

	public final void registerInGamePanel(InGamePanel igp) {
		this.igp = igp;
	}

	public final void registerTwoPLGameRound(ParallelGR gr) {
		this.gr = gr;
	}

	public final InGamePanel getIgp() {
		return igp;
	}

	public final ParallelGR getGr() {
		return gr;
	}
}
