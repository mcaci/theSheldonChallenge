package javapp.tsc.GUI.listeners.help;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javapp.tsc.GUI.components.ruleHelp.RuleHelpTable;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import core.tsc.lang.vocab.OutcomeMessage;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;
import core.tsc.rule.ruleSet.exception.UnexpectedRuleSetException;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

public class SelectedMoveListener implements ItemListener {
	
	private JComboBox ruleCBox;
	private RuleHelpTable helpTable;

	public SelectedMoveListener(JComboBox ruleCBox, RuleHelpTable helpTable) {
		this.ruleCBox = ruleCBox;
		this.helpTable = helpTable;
	}

	@Override
	public final void itemStateChanged(ItemEvent arg0) {
		System.out.println(arg0.getItem());
		if(arg0.getItem().equals("select move...")){
			return;
		}
		
		
		this.helpTable.setVisible(true);
		
		Rule rule = Rule.valueOf(ruleCBox.getModel().getSelectedItem().toString());
		IRuleSet move = null;
		
		Vector<Vector<String>> dataV = new Vector<Vector<String>>();
		for(int i = 0; i < 2; i++){
			dataV.add(new Vector<String>());
		}
		
		switch (rule) {
		case CLASSIC:
			move = ClassicRuleSet.valueOf(arg0.getItem().toString());
			ClassicRuleSet[] listC = ClassicRuleSet.values();
			for(int i = 0; i < listC.length; i++){
				try {
					boolean win = move.winsOver(listC[i]);
					boolean tie = move.tiesWith(listC[i]);
					if(win){
						dataV.get(0).add(listC[i].name());
					} else if(!tie) {
						dataV.get(1).add(listC[i].name());
					}
				} catch (UnexpectedRuleSetException e) {
					e.printStackTrace();
				}
			}
			break;
		case SHELDON:
			move = SheldonRuleSet.valueOf(arg0.getItem().toString());
			SheldonRuleSet[] listS = SheldonRuleSet.values();
			for(int i = 0; i < listS.length; i++){
				try {
					boolean win = move.winsOver(listS[i]);
					boolean tie = move.tiesWith(listS[i]);
					if(win){
						dataV.get(0).add(listS[i].name());
					} else if(!tie) {
						dataV.get(1).add(listS[i].name());
					}
				} catch (UnexpectedRuleSetException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			// TODO something?
			break;
		}
		
		// Fill table
		String[] columnNames = new String[] { 
				OutcomeMessage.WIN.name(),
				OutcomeMessage.LOSS.name() };
		
		TableModel defaultModel = new DefaultTableModel(convert(dataV),
				columnNames);

		helpTable.setModel(defaultModel);
	}
	
	private String[][] convert(Vector<Vector<String>> item){
		String[][] itemNew = new String[10][4];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 4; j++){
				itemNew[i][j] = item.get(i).get(j);
			}
		}
		return itemNew;
	}

}
