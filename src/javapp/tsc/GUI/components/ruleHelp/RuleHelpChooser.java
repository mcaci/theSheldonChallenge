package javapp.tsc.GUI.components.ruleHelp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import core.tsc.lang.vocab.OptionMenuLabel;
import core.tsc.lang.vocab.OtherLabel;

class RuleHelpChooser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 564275352023778360L;

	private ChooserComboBox ruleChooser;
	private ChooserComboBox moveChooser;

	public RuleHelpChooser() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout(1, 2);
			thisLayout.setColumns(2);
			this.setLayout(thisLayout);
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new java.awt.Dimension(200, 45));
			// this.setBorder(new LineBorder(Color.BLACK));
			{
				ruleChooser = new ChooserComboBox(OptionMenuLabel.RULE);
				FlowLayout jPanel1Layout = new FlowLayout();
				ruleChooser.setLayout(jPanel1Layout);
				this.add(ruleChooser);
				ruleChooser.setPreferredSize(new java.awt.Dimension(75, 45));
			}
			{
				moveChooser = new ChooserComboBox(OtherLabel.MOVE);
				FlowLayout jPanel2Layout = new FlowLayout();
				moveChooser.setLayout(jPanel2Layout);
				this.add(moveChooser);
				moveChooser.setPreferredSize(new java.awt.Dimension(88, 45));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
