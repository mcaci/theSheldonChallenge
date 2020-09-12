/**
 * 
 */
package rule.sheldon;

 
/**
 * @author nikiforos
 *
 */
public enum SheldonRuleSet{
	ROCK{
		@Override
		public final boolean winsOver(SheldonRuleSet otherMove){
			if(otherMove.equals(SCISSORS)){return true;}
			else if(otherMove.equals(LIZARD)){return true;}
			else{return false;}
		}
	},
	PAPER {
		@Override
		public final boolean winsOver(SheldonRuleSet otherMove){
			if(otherMove.equals(ROCK)){return true;}
			else if(otherMove.equals(SPOCK)){return true;}
			else{return false;}
		}
	},
	SCISSORS {
		@Override
		public final boolean winsOver(SheldonRuleSet otherMove){
			if(otherMove.equals(PAPER)){return true;}
			else if(otherMove.equals(LIZARD)){return true;}
			else{return false;}
		}
	},
	LIZARD {
		@Override
		public final boolean winsOver(SheldonRuleSet otherMove) {
			if(otherMove.equals(PAPER)){return true;}
			else if(otherMove.equals(SPOCK)){return true;}
			else{return false;}
		}
	},
	SPOCK {
		@Override
		public final boolean winsOver(SheldonRuleSet otherMove) {
			if(otherMove.equals(SCISSORS)){return true;}
			else if(otherMove.equals(ROCK)){return true;}
			else{return false;}
		}
	}
	;
	
	/**
	 * @param otherMove move of the player we want to compare
	 * @return if this move beats the other
	 */
	public abstract boolean winsOver(SheldonRuleSet otherMove);
	
	/**
	 * @param otherMove move of the player we want to compare
	 * @return whether the two moves tie
	 */
	public final boolean tiesWith(SheldonRuleSet otherMove){
		return this.equals(otherMove);
	}
}
