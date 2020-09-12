/**
 * 
 */
package javapp.tsc.roundResolver;

import core.tsc.player.IPlayer;
import core.tsc.rule.ruleSet.IRuleSet;
import core.tsc.rule.ruleSet.exception.UnexpectedRuleSetException;

/**
 * @author nikiforos Classic RoundResolver for two IPlayers
 */
public class TwoPLRoundResolver implements ITwoPlayersRR {

	private IPlayer p1;
	private IPlayer p2;

	/**
	 * @param playerSet
	 * 
	 */
	public TwoPLRoundResolver(IPlayer p1, IPlayer p2) {
		this.setP1(p1);
		this.setP2(p2);
	}

	/**
	 * @return round winner (may be null)
	 */
	public final IPlayer resolve() {
		IPlayer roundWinner = null;

		// TODO: nullPointerException here for who?? IRuleSet or IPlayer
		IRuleSet crs1 = this.getP1().getMove();
		IRuleSet crs2 = this.getP2().getMove();
		try {
			if (crs1.winsOver(crs2)) {
				roundWinner = this.getP1();
			} else if (crs2.winsOver(crs1)) {
				roundWinner = this.getP2();
			} else if (crs1.tiesWith(crs2)) {
				// no winners
			}
		} catch (UnexpectedRuleSetException e) {
			e.printStackTrace();
		}

		// may return null
		return roundWinner;
	}

	public final IPlayer getP1() {
		return p1;
	}

	public final void setP1(IPlayer p1) {
		this.p1 = p1;
	}

	public final IPlayer getP2() {
		return p2;
	}

	public final void setP2(IPlayer p2) {
		this.p2 = p2;
	}

}
