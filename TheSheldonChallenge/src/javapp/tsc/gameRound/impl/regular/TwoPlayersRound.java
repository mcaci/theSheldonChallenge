package javapp.tsc.gameRound.impl.regular;

import javapp.tsc.gameRound.IGameRound;
import javapp.tsc.gameSession.impl.regular.RoundBasedGS;
import javapp.tsc.lang.translator.XMLFileTranslator;
import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.player.IPlayer;
import core.tsc.rule.Rule;

/**
 * Only for RoundBasedGS
 * @author nikiforos
 *
 */
public abstract class TwoPlayersRound implements IGameRound {

	private IPlayer p1, p2;
	private Rule ruleUsed;

	private int roundNum = 0;

	public TwoPlayersRound(RoundBasedGS info) {
		this.initializeFields(info.getP1(), info.getP2(), AppCore.getInstance()
				.getSessionRule(), info.getCurrentRound());
	}

	@Deprecated
	public TwoPlayersRound(RoundBasedGS info, int roundNum) {
		this.initializeFields(info.getP1(), info.getP2(), info.getP1()
				.getRuleUsed(), roundNum);
	}

	@Override
	public abstract void run();

	protected final void initializeFields(IPlayer p1, IPlayer p2,
			Rule ruleUsed, int roundNum) {
		this.setP1(p1);
		this.setP2(p2);
		this.setRuleUsed(ruleUsed);
		this.setRoundNum(roundNum);
	}

	@Override
	public final String toString() {
		String info = "";
		Language currentLang = AppCore.getInstance().getSessionLanguage();
		// round number
		info += "Round #" + this.getRoundNum() + "\n";
		// player actions
		info += new XMLFileTranslator().translate(this.getP1().getMove(),
				currentLang)
				+ " "
				+ new XMLFileTranslator().translate(this.getP2().getMove(),
						currentLang) + "\n";
		// player names + updated score
		info += this.getP1().getName() + ": " + this.getP1().getScore() + " - "
				+ this.getP2().getName() + ": " + this.getP2().getScore()
				+ "\n";

		return info;
	}

	public final void printRoundInformation() {
		System.out.println(this.toString());
	}

	public final IPlayer getP1() {
		return p1;
	}

	protected final void setP1(IPlayer p1) {
		this.p1 = p1;
	}

	public final IPlayer getP2() {
		return p2;
	}

	protected final void setP2(IPlayer p2) {
		this.p2 = p2;
	}

	public final int getRoundNum() {
		return roundNum;
	}

	protected final void setRoundNum(int roundNum) {
		this.roundNum = roundNum;
	}

	protected final Rule getRuleUsed() {
		return ruleUsed;
	}

	protected final void setRuleUsed(Rule rules) {
		this.ruleUsed = rules;
	}
}
