package javapp.tsc.GUI.components.ruleHelp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.Translatable;
import core.tsc.lang.translator.XMLFileTranslator;

public final class ChooserComboBox extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8534439884635738334L;

	private JComboBox chooser;
	private JLabel name;

	public ChooserComboBox(Translatable label) {
		super();
		initGUI(label);
	}

	private void initGUI(Translatable label) {
		try {
			GridLayout grid = new GridLayout(1, 2);
			grid.setColumns(2);
			this.setLayout(grid);
			this.setPreferredSize(new java.awt.Dimension(216, 68));
			{
				FlowLayout flow = new FlowLayout();
				this.setLayout(flow);
				this.setPreferredSize(new java.awt.Dimension(75, 165));
				{
					final Language currentLang = AppCore.getInstance()
							.getSessionLanguage();
					name = new JLabel();
					BorderLayout jLabel1Layout = new BorderLayout();
					this.add(name);
					name.setLayout(jLabel1Layout);
					name.setText(new XMLFileTranslator().translate(label,
							currentLang));
					name.setPreferredSize(new java.awt.Dimension(68, 10));
					name.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					ComboBoxModel content = null;
					// TODO: change the chooser table
					// switch(label){
					// case RULE:
					// content = new
					// DefaultComboBoxModel(Rule.getStringVector());
					// AppCore.helpRule = Rule.CLASSIC;
					// break;
					// case MOVE:
					// Rule r = AppCore.helpRule;
					// switch(r){
					// case CLASSIC:
					// content = new
					// DefaultComboBoxModel(ClassicRuleSet.getStringVector());
					// break;
					// case SHELDON:
					// content = new
					// DefaultComboBoxModel(SheldonRuleSet.getStringVector());
					// break;
					// default:
					// break;
					// }
					// break;
					// default:
					// content = new DefaultComboBoxModel(
					// new String[] { "Item One", "Item Two" });
					// break;
					// }
					chooser = new JComboBox();
					this.add(chooser);
					chooser.setModel(content);
					chooser.setPreferredSize(new java.awt.Dimension(80, 25));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
