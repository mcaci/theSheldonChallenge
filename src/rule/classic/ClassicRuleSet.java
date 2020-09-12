/**
 * 
 */
package rule.classic;

 
/**
 * @author nikiforos
 *
 */
public enum ClassicRuleSet{
	ROCK{
		@Override
		public final boolean winsOver(ClassicRuleSet otherMove){
			if(otherMove.equals(SCISSORS)){return true;}
			else{return false;}
		}
	},
	PAPER {
		@Override
		public final boolean winsOver(ClassicRuleSet otherMove){
			if(otherMove.equals(ROCK)){return true;}
			else{return false;}
		}
	},
	SCISSORS {
		@Override
		public final boolean winsOver(ClassicRuleSet otherMove){
			if(otherMove.equals(PAPER)){return true;}
			else{return false;}
		}
	};
	
	/**
	 * @param otherMove move of the player we want to compare
	 * @return if this move beats the other
	 */
	public abstract boolean winsOver(ClassicRuleSet otherMove);
	
	/**
	 * @param otherMove move of the player we want to compare
	 * @return whether the two moves tie
	 */
	public final boolean tiesWith(ClassicRuleSet otherMove){
		return this.equals(otherMove);
	}
}
