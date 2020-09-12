package javapp.tsc.player.impl;

import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;
import core.tsc.player.impl.DefaultPlayer;
import core.tsc.rule.Rule;

public abstract class AlwaysAlivePlayer extends DefaultPlayer {

	public AlwaysAlivePlayer(String name, Rule ruleUsed)
			throws NoPlayerNameException, UnknownRuleException {
		super(name, ruleUsed);
		
		// TODO: to implement
		
		try{
			throw new Exception("AAPlayer not implemented yet");
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
