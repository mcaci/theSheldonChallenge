package javapp.tsc.GUI.components.chooser;

import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

final class SheldonChooserButton extends DefaultChooserButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -931835533189332204L;

	public SheldonChooserButton(SheldonRuleSet value) {
		super(value);
	}

	@Override
	public final SheldonRuleSet getCorrespondingMove() {
		return (SheldonRuleSet) super.getCorrespondingMove();
	}

}
