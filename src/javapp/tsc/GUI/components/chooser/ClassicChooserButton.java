package javapp.tsc.GUI.components.chooser;

import core.tsc.rule.ruleSet.impl.ClassicRuleSet;

final class ClassicChooserButton extends DefaultChooserButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -931835533189332204L;

	public ClassicChooserButton(ClassicRuleSet value) {
		super(value);
	}

	@Override
	public final ClassicRuleSet getCorrespondingMove() {
		return (ClassicRuleSet) super.getCorrespondingMove();
	}

}
