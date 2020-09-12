/**
 * 
 */
package javapp.tsc.gameRound.impl.regular;

import javapp.tsc.gameRound.IGameRound;
import javapp.tsc.gameSession.impl.regular.RoundBasedGS;
import javapp.tsc.lang.translator.XMLFileTranslator;
import core.tsc.AppCore;
import core.tsc.lang.Language;

/**
 * Only for RoundBasedGS
 * @author nikiforos
 *
 */
public abstract class GSBasedRound implements IGameRound {
	
	private RoundBasedGS info;
	private int roundNum = 0;

	public GSBasedRound(RoundBasedGS info) {
		this.info = info;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public abstract void run();
	
	@Override
	public final String toString() {
		String info = "";
		Language currentLang = AppCore.getInstance().getSessionLanguage();
		// round number
		info += "Round #" + this.getRoundNum() + "\n";
		// player actions
		info += new XMLFileTranslator().translate(this.getInfo().getP1().getMove(),
				currentLang)
				+ " "
				+ new XMLFileTranslator().translate(this.getInfo().getP2().getMove(),
						currentLang) + "\n";
		// player names + updated score
		info += this.getInfo().getP1().getName() + ": " + this.getInfo().getP1().getScore() + " - "
				+ this.getInfo().getP2().getName() + ": " + this.getInfo().getP2().getScore()
				+ "\n";

		return info;
	}

	public final RoundBasedGS getInfo() {
		return info;
	}

	protected final void setInfo(RoundBasedGS info) {
		this.info = info;
	}

	public final int getRoundNum() {
		return roundNum;
	}

	protected final void setRoundNum(int roundNum) {
		this.roundNum = roundNum;
	}

}
