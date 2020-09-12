package javapp.tsc.GUI.listeners.help;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.OtherLabel;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

public class SelectedRuleActionListener implements ActionListener {
	
	private JComboBox moveCBox;

	public SelectedRuleActionListener(JComboBox moveCBox) {
		this.moveCBox = moveCBox;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.moveCBox.setVisible(true);
		
		ComboBoxModel content = null;

		final Language lang = AppCore.getInstance().getSessionLanguage();
		final String ruleString = ((JComboBox) arg0.getSource()).getModel().getSelectedItem().toString();
		if(ruleString.equals(Rule.CLASSIC.name())){
			content = new DefaultComboBoxModel(ClassicRuleSet.getTranslatedStringVector(lang));
		}
		else if(ruleString.equals(Rule.SHELDON.name())){
			content = new DefaultComboBoxModel(SheldonRuleSet.getTranslatedStringVector(lang));
		}
		else{
			content = new DefaultComboBoxModel();
		}
		final String moveString = new XMLTranslator().translate(OtherLabel.MOVE, lang);
		this.moveCBox.setModel(content);
		this.moveCBox.getModel().setSelectedItem(moveString);
	}

}
