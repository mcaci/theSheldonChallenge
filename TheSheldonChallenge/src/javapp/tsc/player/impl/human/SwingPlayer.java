/**
 * 
 */
package javapp.tsc.player.impl.human;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.ipc.sync.SwingButtonHook;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.afc.AliveForChoosingPlayer;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

/**
 * @author nikiforos
 * 
 */
public final class SwingPlayer extends AliveForChoosingPlayer {

	private SwingButtonHook buttonWaiter = null;

	/**
	 * @param p
	 * @param ruleUsed
	 */
	public SwingPlayer(String name, Rule ruleUsed) throws NoPlayerNameException,
			UnknownRuleException {
		super(name, ruleUsed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see player.IPlayer#chooseMove(rule.RuleList)
	 */
	@Override
	public final IRuleSet chooseMove(Rule ruleUsed) throws UnknownRuleException {

		InGamePanel igp = GUICore.getInstance().getIgp();

		SwingButtonHook playerSynchronizer = new SwingButtonHook(this);
		igp.setPlayerSynchronizer(playerSynchronizer);
		this.setButtonWaiter(playerSynchronizer);
		this.getButtonWaiter().holdIt();

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

	public void setButtonWaiter(SwingButtonHook buttonWaiter) {
		this.buttonWaiter = buttonWaiter;
	}

	public SwingButtonHook getButtonWaiter() {
		return buttonWaiter;
	}

}
