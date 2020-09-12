package javapp.tsc.GUI.listeners.help;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javapp.tsc.GUI.components.ruleHelp.RuleHelpTable;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.OtherLabel;
import core.tsc.lang.vocab.OutcomeMessage;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;
import core.tsc.rule.ruleSet.exception.UnexpectedRuleSetException;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

public class SelectedMoveActionListener implements ActionListener {
	
	private JComboBox ruleCBox;
	private RuleHelpTable helpTable;

	public SelectedMoveActionListener(JComboBox ruleCBox, RuleHelpTable helpTable) {
		this.ruleCBox = ruleCBox;
		this.helpTable = helpTable;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox moveCBox = (JComboBox) arg0.getSource();
		final int moveIndex = moveCBox.getSelectedIndex(); 
		String moveString = moveCBox.getModel().getSelectedItem().toString();
		final Rule rule = Rule.valueOf(ruleCBox.getModel().getSelectedItem().toString());
		final Language lang = AppCore.getInstance().getSessionLanguage();
		final String moveLabel = new XMLTranslator().translate(OtherLabel.MOVE, lang);
		
		if(moveString.equals(moveLabel)){
			return;
		}
		{
			moveCBox = null;
		}
		
		this.helpTable.setVisible(true);
		
		IRuleSet move = null;
		
		final Vector<Vector<String>> tableData = new Vector<Vector<String>>();
		for(int i = 0; i < 2; i++){
			tableData.add(new Vector<String>());
		}
		
		switch (rule) {
		case CLASSIC:
			move = ClassicRuleSet.values()[moveIndex];
			final ClassicRuleSet[] listC = ClassicRuleSet.values();
			for(int i = 0; i < listC.length; i++){
				try {
					final boolean win = move.winsOver(listC[i]);
					final boolean tie = move.tiesWith(listC[i]);
					moveString = new XMLTranslator().translate(listC[i], lang);
					if(win){
						tableData.get(0).add(moveString);
					} else if(!tie) {
						tableData.get(1).add(moveString);
					}
				} catch (UnexpectedRuleSetException e) {
					e.printStackTrace();
				}
			}
			break;
		case SHELDON:
			move = SheldonRuleSet.values()[moveIndex];
			final SheldonRuleSet[] listS = SheldonRuleSet.values();
			for(int i = 0; i < listS.length; i++){
				try {

					moveString = new XMLTranslator().translate(listS[i], lang);
					final boolean win = move.winsOver(listS[i]);
					final boolean tie = move.tiesWith(listS[i]);
					if(win){
						tableData.get(0).add(moveString);
					} else if(!tie) {
						tableData.get(1).add(moveString);
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
		final String[] columnNames = new String[] { 
				new XMLTranslator().translate(OutcomeMessage.WIN, lang),
				new XMLTranslator().translate(OutcomeMessage.LOSS, lang)};
		
		final TableModel defaultModel = new DefaultTableModel(convert(tableData),
				columnNames);

		helpTable.setModel(defaultModel);
		
	}

	private final String[][] convert(final Vector<Vector<String>> item){
		
		final int winLength = item.get(0).size();
		final int loseLength = item.get(1).size();
		final int max = (winLength > loseLength ? winLength : loseLength);
		final String[][] itemNew = new String[max][2];
		
		for(int i = 0; i < max; i++){
			for(int j = 0; j < 2; j++){
				itemNew[i][j] = item.get(j).get(i);
			}
		}
		return itemNew;
	}

}
