/**
 * 
 */
package core.tsc;

import core.tsc.lang.Language;
import core.tsc.rule.Rule;

/**
 * Data structure required when merging all AppCore data
 * @author nikiforos
 *
 */
public class AppCoreData {

	private String nameP1;
	private String nameP2;
	private AppCoreOptionPanelData data;

	/**
	 * 
	 */
	public AppCoreData(String p1, String p2, String langComp, String scoreComp, String ruleComp){
		this.setPlayerNames(p1, p2);
		this.data = new AppCoreOptionPanelData(langComp, scoreComp, ruleComp);
	}
	
	/**
	 * 
	 */
	public AppCoreData(String p1, String p2, Language lang, int maxScore, Rule rule){
		this.setPlayerNames(p1, p2);
		this.data = new AppCoreOptionPanelData(lang, maxScore, rule);
	}
	
	// (?) this is more important because it checks every field one at a time
	@Deprecated
	public final void setAll(String p1, String p2, Language lang, int maxScore, Rule rule){
		this.setPlayerNames(p1, p2);
		this.setOptionData(lang, maxScore, rule);
	}
	
	public final AppCoreData setPlayerNames(String p1, String p2){
		if(p1 != null) nameP1 = p1;
		if(p2 != null) nameP2 = p2;
		return this;
	}

	public final void setOptionData(Language lang, int maxScore, Rule rule) {
		this.data.setAll(lang, maxScore, rule);		
	}
	
	public final void setOptionData(String lang, String maxScore, String rule) {
		this.data = new AppCoreOptionPanelData(lang, maxScore, rule);		
	}

	/**
	 * @since 1.6 because of isEmpty() - for android use Level 9
	 */
	public final void enforceConsistencyNonBackwardsCompatible(){
		try{
			throw new Exception("unused for now");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		if(nameP1.isEmpty() || nameP1 == null) nameP1 = AppCore.DEFAULT_NAME_P1;
//		if(nameP2.isEmpty() || nameP2 == null) nameP2 = AppCore.DEFAULT_NAME_P2;
//		data.enforceConsistency();
	}
	
	public final void enforceConsistency(){
		if((nameP1.length() == 0) || nameP1 == null) nameP1 = AppCore.DEFAULT_NAME_P1;
		if((nameP2.length() == 0) || nameP2 == null) nameP2 = AppCore.DEFAULT_NAME_P2;
		data.enforceConsistency();
	}
	
	@Override
	public final String toString() {
		return "GAME DATA: "
			+ "Player 1 name is \"" + this.getNameP1() + "\""
			+ "Player 2 name is \"" + this.getNameP2() + "\""
			+ "The language used is " + this.getOptionData().getSessionLanguage()
			+ "The score to reach is " + this.getOptionData().getScoreToWin()
			+ "The rule used is " + this.getOptionData().getSessionRule();
	}

	/**
	 * @return the nameP1
	 */
	final String getNameP1() {
		return nameP1;
	}

	/**
	 * @return the nameP2
	 */
	final String getNameP2() {
		return nameP2;
	}

	/**
	 * @return the data
	 */
	final AppCoreOptionPanelData getOptionData() {
		return data;
	}

}
