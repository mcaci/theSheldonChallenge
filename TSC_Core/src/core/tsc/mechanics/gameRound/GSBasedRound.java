/**
 * 
 */
package core.tsc.mechanics.gameRound;

import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.mechanics.gameSession.classic.ClassicGS;
import core.tsc.mechanics.roundResolver.ITwoPlayersRR;
import core.tsc.mechanics.roundResolver.TwoPLRoundResolver;
import core.tsc.player.IPlayer;
import core.tsc.player.util.InGameStatus;

/**
 * Only for RoundBasedGS
 * @author nikiforos
 *
 */
public abstract class GSBasedRound implements IGameRound {
	
	private ClassicGS info;
	private int roundNum = 0;
	
	public GSBasedRound(ClassicGS info) {
		this.setInfo(info);
		this.setRoundNum(info.getCurrentRound() + 1);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	protected abstract boolean promptMoves(IPlayer p1, IPlayer p2);
	
	@Override
	public final void run() {
		// PHASE 1: prompt for choice
		this.promptMoves(this.getInfo().getP1(), this.getInfo().getP2());

		// TODO: remove comments
//		this.playerMediator.notifyPlayers();
//		this.playerMediator.waitForPlayers();

		// PHASE 1.1: check for player that surrendered
		if (this.checkForSurrender(this.getInfo().getP1(), this.getInfo().getP2())) {
			Thread.currentThread().interrupt();
			return;
		}

		// PHASE 2: collects and resolves
		ITwoPlayersRR rr = new TwoPLRoundResolver(this.getInfo().getP1(),
				this.getInfo().getP2());
		rr.run();

		// TODO: update the rule explanator
		// RuleSetExplanator re = null;
		// switch (this.getRuleUsed()) {
		// case CLASSIC:
		// re = new ClassicRuleExplanatorEng();
		// break;
		// case SHELDON:
		// re = new SheldonRuleExplanatorEng();
		// break;
		// }
		// String explanation = re.explain(this.getP1(), this.getP2());
		// System.out.println(explanation);
	}
	
	protected final boolean checkPlayers(IPlayer p1, IPlayer p2) {
		boolean flag = true;
		flag &= p1.checkIfPlayerStateIs(InGameStatus.PERFORMED_MOVE);
		flag &= p2.checkIfPlayerStateIs(InGameStatus.PERFORMED_MOVE);
		return flag;
	}

	protected final boolean checkForSurrender(IPlayer p1, IPlayer p2) {
		boolean flag = false;
		flag |= (p1.getMove() == null);
		flag |= (p2.getMove() == null);
		return flag;
	}
	
	@Override
	public final String toString() {
		String info = "";
		Language currentLang = AppCore.getInstance().getSessionLanguage();
		// round number
		info += "Round #" + this.getRoundNumber() + "\n";
		// player actions (TODO: remove the comments)
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

	public final ClassicGS getInfo() {
		return info;
	}

	protected final void setInfo(ClassicGS info) {
		this.info = info;
	}

	@Override
	public final int getRoundNumber() {
		return roundNum;
	}

	protected final void setRoundNum(int roundNum) {
		this.roundNum = roundNum;
	}

}
