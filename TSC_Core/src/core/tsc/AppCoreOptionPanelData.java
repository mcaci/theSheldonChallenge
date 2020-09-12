package core.tsc;

/**
 * Data required in AppCore.
 * 
 * @author nikiforos
 *
 */
import core.tsc.lang.Language;
import core.tsc.mechanics.gameSession.IGameSession;
import core.tsc.rule.Rule;

final class AppCoreOptionPanelData {
	
	private Language sessionLanguage;
	private int scoreToWin;
	private Rule sessionRule;
	
    AppCoreOptionPanelData(Language lang, int maxScore, Rule rule){
		this.setAll(lang, maxScore, rule);
	}
    
    AppCoreOptionPanelData(String langComp, String scoreComp, String ruleComp){
    	
    	// string -> language
    	Language lang = Language.defaultElement();
    	if(langComp != null){
    		try {
    			lang = Language.valueOf(langComp);
    		} catch(IllegalArgumentException e){
    			e.printStackTrace();
    			lang = Language.defaultElement();
    		}
    	}
		
		// string -> maxScore
    	int maxScore = IGameSession.DEFAULT_WIN_SCORE;
    	if(scoreComp != null){
			try {
				maxScore = Integer.parseInt(scoreComp);
			} catch(NumberFormatException e){
				// TODO: any other exceptions to catch?
				e.printStackTrace();
				maxScore = IGameSession.DEFAULT_WIN_SCORE;
			}
    	}
		
		// string -> rule
		Rule rule = Rule.defaultElement();
    	if(ruleComp != null){
    		try {
    			rule = Rule.valueOf(ruleComp);
    		} catch(IllegalArgumentException e){
    			e.printStackTrace();
    			rule = Rule.defaultElement();
    		}
    	}
    	
    	this.setAll(lang, maxScore, rule);
    }
    
	final AppCoreOptionPanelData setAll(Language lang, int maxScore, Rule rule){
		if(lang != null) this.sessionLanguage = lang;
		if(maxScore > 0) this.scoreToWin = maxScore;
		if(rule != null) this.sessionRule = rule;
		return this;
	}
    
    final void enforceConsistency(){
		if(sessionLanguage == null) sessionLanguage = Language.defaultElement();
		if(scoreToWin < 1) scoreToWin = IGameSession.DEFAULT_WIN_SCORE;
		if(sessionRule == null) sessionRule = Rule.defaultElement();
	}
    
	@Override
	public final String toString() {
		return "OPTIONS DATA: "
			+ "Language: " + AppCore.getInstance().getSessionLanguage()
			+ "MaxScore: " + AppCore.getInstance().getScoreToWin()
			+ "Rule: " + AppCore.getInstance().getSessionRule();
	}
	
	/**
	 * @return the sessionLanguage
	 */
	final Language getSessionLanguage() {
		return this.sessionLanguage;
	}

	/**
	 * @return the scoreToWin
	 */
	final int getScoreToWin() {
		return this.scoreToWin;
	}

	/**
	 * @return the sessionRule
	 */
	final Rule getSessionRule() {
		return this.sessionRule;
	}

}
