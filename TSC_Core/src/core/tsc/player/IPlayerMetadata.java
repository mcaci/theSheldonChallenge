package core.tsc.player;

import core.tsc.player.util.PlayerState;
import core.tsc.player.util.PlayerStatus;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

interface IPlayerMetadata {
	
	/*
	 * String to represent the name
	 */
	public abstract String getName();
	/*
	 * int to represent the score
	 */
	public abstract int getScore();
	/*
	 * Rule to represent the information on the rule used (which is necessary for the Player to know how to choose the move)
	 */
	public abstract Rule getRuleUsed();
	/*
	 * Move to represent the move
	 */
	public abstract IRuleSet getMove();
	/*
	 * PlayerStates to represent the playing state 
	 */
	public abstract PlayerState getPlayerState();
	/*
	 * PlayerStatuses to represent the winning state 
	 */
	public abstract PlayerStatus getPlayerStatus();

}
