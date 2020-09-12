package javapp.tsc.GUI.components.chooser;

import javax.swing.JButton;

import core.tsc.AppCore;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.rule.ruleSet.IRuleSet;

public abstract class DefaultChooserButton extends JButton implements
		IChooserButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2549525473846041958L;
	
	IRuleSet correspondingMove;
	
	DefaultChooserButton(IRuleSet value) {
		this.correspondingMove = value;
		setText(new XMLTranslator().translate(value, AppCore
				.getInstance().getSessionLanguage()));
	}

	@Override
	public IRuleSet getCorrespondingMove() {
		return this.correspondingMove;
	}

}
