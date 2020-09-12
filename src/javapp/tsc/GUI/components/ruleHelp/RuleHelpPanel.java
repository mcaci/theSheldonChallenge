/**
 * 
 */
package javapp.tsc.GUI.components.ruleHelp;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javapp.tsc.GUI.listeners.help.SelectedMoveActionListener;
import javapp.tsc.GUI.listeners.help.SelectedRuleActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.OptionMenuLabel;
import core.tsc.lang.vocab.OtherMessage;
import core.tsc.rule.Rule;

/**
 * @author nikiforos
 * 
 */
public final class RuleHelpPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -723166127228229282L;

	private JComboBox moveCBox;

	private RuleHelpTable helpTable;
	private JLabel tieLabel;

	public RuleHelpPanel() {
		super();
		this.initGUI();
	}

	private final void initGUI() {
		try {
			final FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
			final Dimension cBoxDimension = new Dimension(168, 24);
			this.setPreferredSize(new Dimension(180, 160));
			this.setLayout(layout);
			{
				final JComboBox ruleCBox = new JComboBox();
				this.add(ruleCBox);
				{
					moveCBox = new JComboBox();
					this.add(moveCBox);
					{
						helpTable = new RuleHelpTable();
						this.add(helpTable);
						
						helpTable.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
						helpTable.setVisible(false);
					}
					moveCBox.setPreferredSize(cBoxDimension);
					moveCBox.setVisible(false);
					
					moveCBox.addActionListener(new SelectedMoveActionListener(ruleCBox, helpTable));
				}
				
				ruleCBox.setPreferredSize(cBoxDimension);
				
				final ComboBoxModel content = new DefaultComboBoxModel(Rule.getStringVector());
				ruleCBox.setModel(content);
				final Language lang = AppCore.getInstance().getSessionLanguage();
				final String rule = new XMLTranslator().translate(OptionMenuLabel.RULE, lang);
				ruleCBox.getModel().setSelectedItem(rule);

				ruleCBox.addActionListener(new SelectedRuleActionListener(moveCBox));
				
			}
			{
				final Language currentLang = AppCore.getInstance()
						.getSessionLanguage();
				tieLabel = new JLabel();
				this.add(tieLabel);
				tieLabel.setText(new XMLTranslator().translate(
						OtherMessage.TIE, currentLang) + "*");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
