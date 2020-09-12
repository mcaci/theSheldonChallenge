package rule.explanator.classic.lang;

import player.Player;
import rule.explanator.classic.ClassicRuleExplanator;

public class ClassicRuleExplanatorIta extends ClassicRuleExplanator {

	public ClassicRuleExplanatorIta(){
		super();
		this.setLanguage("Italiano");
		this.setPR("La carta avvolge il sasso");
		this.setRS("Il sasso spezza le forbici");
		this.setSP("Le forbici tagliano la carta");
		this.setTIE("PARI");
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
