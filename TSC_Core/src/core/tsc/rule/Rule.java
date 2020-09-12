/**
 * 
 */
package core.tsc.rule;


import core.tsc.rule.ruleSet.IRuleSet;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;



/**
 * @author nikiforos
 * 
 */
public enum Rule {
	CLASSIC {
		@Override
		public final ClassicRuleSet[] getRuleSet() {
			return ClassicRuleSet.values();
		}

		@Override
		public final ClassicRuleSet randomValue() {
			return ClassicRuleSet.values()[(int) (Math.random() * ClassicRuleSet.values().length)];
		}

	},
	SHELDON {
		@Override
		public final SheldonRuleSet[] getRuleSet() {
			return SheldonRuleSet.values();
		}

		@Override
		public final SheldonRuleSet randomValue() {
			return SheldonRuleSet.values()[(int) (Math.random() * SheldonRuleSet.values().length)];
		}

	};
	
	
	public abstract IRuleSet randomValue();
	public abstract IRuleSet[] getRuleSet();
	
	public static final Rule defaultElement(){
		return CLASSIC;
	}
	
	public static final String[] getStringVector() {
		Rule[] ruleVect = Rule.values();
		String[] stringVect = new String[ruleVect.length];
		for (int i = 0; i < ruleVect.length; i++) {
			stringVect[i] = ruleVect[i].name();
		}
		return stringVect;
	}
	
}
