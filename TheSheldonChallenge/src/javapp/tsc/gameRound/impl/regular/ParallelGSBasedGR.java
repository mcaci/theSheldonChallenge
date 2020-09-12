package javapp.tsc.gameRound.impl.regular;

import javapp.tsc.core.IntercomCore;
import javapp.tsc.gameSession.impl.regular.RoundBasedGS;
import javapp.tsc.mediation.MoveLabelUpdater;
import javapp.tsc.mediation.playerGR.PlayerRoundMediator;
import javapp.tsc.roundResolver.TwoPLRoundResolver;
import core.tsc.player.IPlayer;
import core.tsc.player.UpdateContext;
import core.tsc.player.exception.UnsuccessfulUpdateException;
import core.tsc.player.util.PlayerState;

public final class ParallelGSBasedGR extends GSBasedRound {

	private MoveLabelUpdater guiCommunicator;
	private PlayerRoundMediator playerMediator;
	
	public ParallelGSBasedGR(RoundBasedGS info) {
		super(info);
		guiCommunicator = IntercomCore.getInstance().getGrCom();
		guiCommunicator.registerGameRound(this);
		playerMediator = IntercomCore.getInstance().getPGRCom();
		playerMediator.registerGameRound(this);
	}

	@Override
	public void run() {
		// PHASE 1: prompt for choice
		this.promptMoves(this.getInfo().getP1(), this.getInfo().getP2());

		this.playerMediator.notifyPlayers();
		this.playerMediator.waitForPlayers();

		// PHASE 1.1: check for player that surrendered
		if (this.checkForSurrender(this.getInfo().getP1(), this.getInfo().getP2())) {
			Thread.currentThread().interrupt();
			return;
		}

		// PHASE 2: collects and resolves
		TwoPLRoundResolver rr = new TwoPLRoundResolver(this.getInfo().getP1(),
				this.getInfo().getP2());
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
				// TODO Auto-generated catch block
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
