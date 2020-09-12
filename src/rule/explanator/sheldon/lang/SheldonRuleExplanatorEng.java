package rule.explanator.sheldon.lang;

import player.Player;
import rule.explanator.sheldon.SheldonRuleExplanator;
import rule.sheldon.SheldonRuleSet;


public class SheldonRuleExplanatorEng extends SheldonRuleExplanator {
	
	public SheldonRuleExplanatorEng(){
		super();
		this.setLanguage("English");

		this.getExplanations()[0] = SheldonRuleSet.LIZARD + " poisons " + SheldonRuleSet.SPOCK;
		this.getExplanations()[1] = SheldonRuleSet.ROCK +  " crushes " + SheldonRuleSet.SCISSORS;
		this.getExplanations()[2] = SheldonRuleSet.PAPER + " covers " + SheldonRuleSet.ROCK;
		this.getExplanations()[3] = SheldonRuleSet.ROCK + " crushes " + SheldonRuleSet.LIZARD;
		this.getExplanations()[4] = SheldonRuleSet.SPOCK + " vaporizes " + SheldonRuleSet.ROCK;
		this.getExplanations()[5] = SheldonRuleSet.SCISSORS + " cut " + SheldonRuleSet.PAPER;
		this.getExplanations()[6] = SheldonRuleSet.LIZARD + " eats " + SheldonRuleSet.PAPER;
		this.getExplanations()[7] = SheldonRuleSet.SCISSORS + " decapitate " + SheldonRuleSet.LIZARD;
		this.getExplanations()[8] = SheldonRuleSet.PAPER + " disproves " + SheldonRuleSet.SPOCK;
		this.getExplanations()[9] = SheldonRuleSet.SPOCK + " smashes " + SheldonRuleSet.SCISSORS;
		
		this.setTIE("TIE");
	}

	@Override
	public String explain(Player p1, Player p2) {
		// TODO Auto-generated method stub
		return super.explain(p1, p2);
	}

	@Override
	protected String explainTie(SheldonRuleSet move) {
		// TODO Auto-generated method stub
		return super.explainTie(move);
	}
	
}
