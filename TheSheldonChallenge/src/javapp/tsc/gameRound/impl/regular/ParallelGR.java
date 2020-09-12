/**
 * 
 */
package javapp.tsc.gameRound.impl.regular;

import javapp.tsc.gameSession.impl.regular.RoundBasedGS;
import javapp.tsc.mediation.MoveLabelUpdaterOLD;
import javapp.tsc.mediation.playerGR.PlayerRoundMediatorOLD;
import javapp.tsc.roundResolver.TwoPLRoundResolver;
import core.tsc.player.IPlayer;
import core.tsc.player.UpdateContext;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.util.PlayerState;

/**
 * @author nikiforos
 * 
 */
public class ParallelGR extends TwoPlayersRound {

	private MoveLabelUpdaterOLD guiCommunicator;
	private PlayerRoundMediatorOLD playerMediator;

	public ParallelGR(RoundBasedGS info) {
		super(info);
//		guiCommunicator = IntercomCore.getInstance().getGrCom();
//		guiCommunicator.registerTwoPLGameRound(this);
//		playerMediator = IntercomCore.getInstance().getPGRCom();
//		playerMediator.registerTwoPLGameRound(this);
	}

	@Override
	public final void run() {
		// PHASE 1: prompt for choice
		this.promptMoves(this.getP1(), this.getP2());

		this.playerMediator.notifyPlayers();
		this.playerMediator.waitForPlayers();

		// PHASE 1.1: check for player that surrendered
		if (this.checkForSurrender(this.getP1(), this.getP2())) {
			Thread.currentThread().interrupt();
			return;
		}

		// PHASE 2: collects and resolves
		TwoPLRoundResolver rr = new TwoPLRoundResolver(this.getP1(),
				this.getP2());
		IPlayer roundWinner = rr.resolve();

		// PHASE 2.1: update gui
		this.guiCommunicator.updateMoveLabels();

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

		// PHASE 3: update roundWinners
		if (roundWinner != null) {
			try {
				roundWinner.updateInfo(UpdateContext.WON_ROUND);
			} catch (UnsuccessfulUpdateException e) {
				e.printStackTrace();
			}
		}
	}

	protected final boolean promptMoves(IPlayer p1, IPlayer p2) {
		new Thread(p1, p1.getName()).start();
		new Thread(p2, p2.getName()).start();
		return true;
	}

	protected final boolean checkPlayers(IPlayer p1, IPlayer p2) {
		boolean flag = true;
		flag &= p1.checkIfPlayerStateIs(PlayerState.PERFORMED_MOVE);
		flag &= p2.checkIfPlayerStateIs(PlayerState.PERFORMED_MOVE);
		return flag;
	}

	protected final boolean checkForSurrender(IPlayer p1, IPlayer p2) {
		boolean flag = false;
		flag |= (p1.getMove() == null);
		flag |= (p2.getMove() == null);
		return flag;
	}

}
