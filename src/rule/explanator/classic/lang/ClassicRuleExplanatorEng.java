package rule.explanator.classic.lang;

import player.Player;
import rule.classic.ClassicRuleSet;
import rule.explanator.classic.ClassicRuleExplanator;


public class ClassicRuleExplanatorEng extends ClassicRuleExplanator {
	
	public ClassicRuleExplanatorEng(){
		super();
		this.setLanguage("English");
		this.setPR(ClassicRuleSet.PAPER + " covers " + ClassicRuleSet.ROCK);
		this.setRS(ClassicRuleSet.ROCK + " crushes " + ClassicRuleSet.SCISSORS);
		this.setSP(ClassicRuleSet.SCISSORS + " cut " + ClassicRuleSet.PAPER);
		this.setTIE("TIE");
	}

	@Override
	public String explain(Player p1, Player p2) {
		// TODO Auto-generated method stub
		return super.explain(p1, p2);
	}

	@Override
	protected String explainTie(Player p1, Player p2) {
		// TODO Auto-generated method stub
		return super.explainTie(p1, p2);
	}
	
}
