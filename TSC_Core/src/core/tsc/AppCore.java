/**
 * 
 */
package core.tsc;

import core.tsc.lang.Language;
import core.tsc.persistency.IOptionManager;
import core.tsc.persistency.exception.ReadNotSupportedException;
import core.tsc.rule.Rule;

/**
 * The very basic data for TSC
 * @author nikiforos
 */
public final class AppCore {

	// GameOptionData field
	private AppCoreData data;
	public static final String DEFAULT_NAME_P1 = "PLAYER 1";
	public static final String DEFAULT_NAME_P2 = "PLAYER 2";
	
	/**
	 * private constructor following the Singleton pattern
	 */
	private AppCore() {}

	/**
	 * class holder for the Singleton pattern
	 */
	private static final class AppCoreHolder {
		public static final AppCore core = new AppCore();
	}

	public static final AppCore getInstance() {
		return AppCoreHolder.core;
	}
	
	/* ****** APPCORE METODS ****** */
	
	

	@Deprecated
	public final void initializeGameData(){
		// dummy initializer
		this.data = new AppCoreData("Pl", "AI", Language.ENGLISH, 3, Rule.CLASSIC);
		this.data.enforceConsistency();
	}
	
	public final void initializeGameData(IOptionManager optLoader){
		// read from file and init real data
		
		try {
			this.data = optLoader.readOptions();
		} catch (ReadNotSupportedException e) {
			e.printStackTrace();
		}
		
		this.data.enforceConsistency();
	}
	
	@Override
	public final String toString() {
		return this.data.toString();
	}
	
	/* ****** GETTERS (and SETTERS?) ****** */

	public final AppCoreData getData() {
		return this.data;
	}
	
	/**
	 * @return the nameP1
	 */
	public final String getNameP1() {
		return this.data.getNameP1();
	}

	/**
	 * @return the nameP2
	 */
	public final String getNameP2() {
		return this.data.getNameP2();
	}

	/**
	 * @return the sessionLanguage
	 */
	public final Language getSessionLanguage() {
		return this.data.getOptionData().getSessionLanguage();
	}

	/**
	 * @return the scoreToWin
	 */
	public final int getScoreToWin() {
		return this.data.getOptionData().getScoreToWin();
	}

	/**
	 * @return the sessionRule
	 */
	public final Rule getSessionRule() {
		return this.data.getOptionData().getSessionRule();
	}
}
