/**
 * 
 */
package core.tsc.mechanics.roundResolver;

import core.tsc.player.IPlayer;
import core.tsc.player.util.PlayerStatus;
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
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public void run() {
		// TODO: nullPointerException here for who?? IRuleSet or IPlayer
		IRuleSet crs1 = this.p1.getMove();
		IRuleSet crs2 = this.p2.getMove();
		try {
			if (crs1.winsOver(crs2)) {
				this.p1.setPlayerStatus(PlayerStatus.ROUND_WINNER);
				this.p2.setPlayerStatus(PlayerStatus.NOT_A_WINNER);
			} else if (crs2.winsOver(crs1)) {
				this.p1.setPlayerStatus(PlayerStatus.NOT_A_WINNER);
				this.p2.setPlayerStatus(PlayerStatus.ROUND_WINNER);
			} else if (crs1.tiesWith(crs2)) {
				this.p1.setPlayerStatus(PlayerStatus.NOT_A_WINNER);
				this.p2.setPlayerStatus(PlayerStatus.NOT_A_WINNER);
			}
		} catch (UnexpectedRuleSetException e) {
			e.printStackTrace();
		}
	}

}
