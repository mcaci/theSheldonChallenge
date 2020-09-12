package rule.explanator.classic;

import player.Player;
import rule.classic.ClassicRuleSet;
import rule.explanator.RuleExplanator;

public abstract class ClassicRuleExplanator extends RuleExplanator {

	private String language = "NONE";
	
	private String RS;
	private String SP;
	private String PR;	
	private String TIE;
	
	protected ClassicRuleExplanator(){
		RS = "";
		SP = "";
		PR = "";
		TIE = "";
	}
	
	@Override
	public String explain(Player p1, Player p2) {
		this.tellPlayersApart(p1, p2);
		
		// tie
		ClassicRuleSet move1 = (ClassicRuleSet) p1.getMove().getPlayerMove();
		ClassicRuleSet move2 = (ClassicRuleSet) p2.getMove().getPlayerMove();
		if(move1.tiesWith(move2)) return explainTie(p1, p2);
		
		// win/lose
		switch((ClassicRuleSet)(getEventualWinner().getMove().getPlayerMove())){
		case ROCK:
			return this.getRS();
		case SCISSORS:
			return this.getSP();
		case PAPER:
			return this.getPR();
		default:
			// Exception Handling here
			return null;
		}
	}
	
	protected String explainTie(Player p1, Player p2) {
//		return "Players tied on " + move.name();
//		return "TIE";
		return this.getTIE();
	}
	
	@Override
	protected void tellPlayersApart(Player p1, Player p2) {
		// Conditional Operator ?: - (condition ? whatIfTrue : whatIfFalse);
		ClassicRuleSet m1 = (ClassicRuleSet) p1.getMove().getPlayerMove();
		ClassicRuleSet m2 = (ClassicRuleSet) p2.getMove().getPlayerMove();
		
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

	protected final String getRS() {
		return RS;
	}

	protected final void setRS(String rS) {
		RS = rS;
	}

	protected final String getSP() {
		return SP;
	}

	protected final void setSP(String sP) {
		SP = sP;
	}

	protected final String getPR() {
		return PR;
	}

	protected final void setPR(String pR) {
		PR = pR;
	}

	protected final String getTIE() {
		return TIE;
	}

	protected final void setTIE(String tIE) {
		TIE = tIE;
	}
}
