/**
 * 
 */
package javapp.tsc.player.impl.human;

import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.core.GUICore;
import javapp.tsc.core.IntercomCore;
import javapp.tsc.mediation.playerGUI.PlayerGUIMediator;
import javapp.tsc.player.impl.AliveForChoosingPlayer;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

/**
 * @author nikiforos
 * 
 */
public final class GUIPlayer extends AliveForChoosingPlayer {

	private PlayerGUIMediator guiPlCom;

	/**
	 * @param p
	 * @param ruleUsed
	 */
	public GUIPlayer(String name, Rule ruleUsed) throws NoPlayerNameException,
			UnknownRuleException {
		super(name, ruleUsed);

		// TODO: unaccettable getP1Com();
		this.guiPlCom = IntercomCore.getInstance().getP1Com();
		this.guiPlCom.registerPlayer(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see player.IPlayer#chooseMove(rule.RuleList)
	 */
	@Override
	public final IRuleSet chooseMove(Rule ruleUsed) throws UnknownRuleException {

		InGamePanel igp = GUICore.getInstance().getIgp();

		guiPlCom.updateWaitForMove();

		switch (ruleUsed) {
		case CLASSIC:
		case SHELDON:
			return igp.getMoveToReturn();
		default:
			throw new UnknownRuleException();
			// code here is unreachable... no return statement (no break even
			// since all return or throw)
		}
	}

}
