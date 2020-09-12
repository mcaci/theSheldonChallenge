package javapp.tsc.GUI.listeners.help;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

public class SelectedRuleListener implements ItemListener {
	
	private JComboBox moveCBox;

	public SelectedRuleListener(JComboBox moveCBox) {
		this.moveCBox = moveCBox;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		this.moveCBox.setVisible(true);
		
		ComboBoxModel content = null;
		
		if(arg0.getItem().equals(Rule.CLASSIC.name())){
			content = new DefaultComboBoxModel(ClassicRuleSet.getStringVector());
		}
		else if(arg0.getItem().equals(Rule.SHELDON.name())){
			content = new DefaultComboBoxModel(SheldonRuleSet.getStringVector());
		}
		else{
			content = new DefaultComboBoxModel();
		}
		this.moveCBox.setModel(content);
		this.moveCBox.getModel().setSelectedItem("select move...");
	}

}
