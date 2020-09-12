package rule.explanator.sheldon;

import player.Player;
import rule.explanator.RuleExplanator;
import rule.sheldon.SheldonRuleSet;

public abstract class SheldonRuleExplanator extends RuleExplanator {

	private String language = "NONE";

	private String[] explanations;
	private String TIE;
	
	protected SheldonRuleExplanator(){
		int size = 10;
		this.setExplanations(new String[size]);
		for(int i = 0; i < size; i++){
			this.getExplanations()[i] = ""; 
		}
		setTIE("");
	}
	
	@Override
	public String explain(Player p1, Player p2) {
		this.tellPlayersApart(p1, p2);
		
		// tie
		SheldonRuleSet move1 = (SheldonRuleSet) this.getEventualWinner().getMove().getPlayerMove();
		SheldonRuleSet move2 = (SheldonRuleSet) this.getEventualLoser().getMove().getPlayerMove();
		if(move1.tiesWith(move2)) return explainTie(move1);
		
		// win/lose
		int coupleMoveCode = getCoupleMoveCode(move1, move2);
		return this.getExplanations()[coupleMoveCode];
		/* TODO: be careful when listing here
		 * CoupleMoveCodes
		PR -> 2
		SpR -> 4
		RSc -> 1
		SpSc -> 9
		ScP -> 5
		LP -> 11 -> 6
		RL -> 3
		ScL -> 7
		PSp -> 14 -> 8
		LSp -> 19 -> 12 -> 0
		*/
	}
	
	protected String explainTie(SheldonRuleSet move) {
//		return "Players tied on " + move.name();
		return "TIE";
	}
	
	@Override
	protected void tellPlayersApart(Player p1, Player p2) {
		// Conditional Operator ?: - (condition ? whatIfTrue : whatIfFalse);
		SheldonRuleSet m1 = (SheldonRuleSet) p1.getMove().getPlayerMove();
		SheldonRuleSet m2 = (SheldonRuleSet) p2.getMove().getPlayerMove();
		
		if(m1.winsOver(m2)){
			super.tellPlayersApart(p1, p2);
		}
		else if(m2.winsOver(m1)){
			super.tellPlayersApart(p2, p1);
		}
		else{ // we give preference to player1 in case of draw
			super.tellPlayersApart(p1, p2);
		}
	}
	
	private static final int getCoupleMoveCode(SheldonRuleSet move1, SheldonRuleSet move2) {
		// base value
		int id = move1.ordinal() * move2.ordinal() + move1.ordinal() + move2.ordinal();
		// first mod (if applicable)
		if(id > 10) id = move1.ordinal() * move2.ordinal();
		// second mod (if applicable)
		if(id > 10) id = 0;
		return id;
	}
	
	/**
	 * @param language the language to set
	 */
	protected final void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the language
	 */
	public final String getLanguage() {
		return language;
	}

	/**
	 * @param explanations the explanations to set
	 */
	protected final void setExplanations(String[] explanations) {
		this.explanations = explanations;
	}

	/**
	 * @return the explanations
	 */
	protected final String[] getExplanations() {
		return explanations;
	}

	/**
	 * @param tIE the tIE to set
	 */
	protected final void setTIE(String tIE) {
		TIE = tIE;
	}

	/**
	 * @return the tIE
	 */
	protected final String getTIE() {
		return TIE;
	}
}
