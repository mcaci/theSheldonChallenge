package core.tsc.player;

import core.tsc.ipc.ISynchro;
import core.tsc.player.util.InGameStatus;
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
	public abstract void setPlayerState(InGameStatus playerState);
	public abstract InGameStatus getPlayerState();
	/*
	 * PlayerStatuses to represent the winning state 
	 */
	public abstract void setPlayerStatus(PlayerStatus playerStatus);
	public abstract PlayerStatus getPlayerStatus();
	/*
	 * Notifier to enable communication with the GameSession phase
	 */
	public abstract void setNotifier(ISynchro notifier);

}
