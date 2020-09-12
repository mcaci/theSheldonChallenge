package javapp.tsc.player.impl;

import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.basic.BasicPlayer;
import core.tsc.rule.Rule;

public abstract class AlwaysAlivePlayer extends BasicPlayer {

	public AlwaysAlivePlayer(String name, Rule ruleUsed)
			throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
	}

}
