package rule.explanator.sheldon.lang;

import player.Player;
import rule.explanator.sheldon.SheldonRuleExplanator;
import rule.sheldon.SheldonRuleSet;

public class SheldonRuleExplanatorIta extends SheldonRuleExplanator {

	public SheldonRuleExplanatorIta(){
		super();
		this.setLanguage("Italiano");

		this.getExplanations()[0] = "La lucertola avvelena spock";
		this.getExplanations()[1] = "Il sasso spezza le forbici";
		this.getExplanations()[2] = "La carta avvolge il sasso";
		this.getExplanations()[3] = "Il sasso uccide la lucertola";
		this.getExplanations()[4] = "Spock vaporizza il sasso";
		this.getExplanations()[5] = "Le forbici tagliano la carta";
		this.getExplanations()[6] = "La lucertola mangia la carta";
		this.getExplanations()[7] = "Le forbici decapitano la lucertola";
		this.getExplanations()[8] = "La carta invalida Spock";
		this.getExplanations()[9] = "Spock rompe le forbici";
		
		this.setTIE("PARI");
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
