package javapp.tsc.GUI.panels.components.ruleHelp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javapp.tsc.lang.vocab.OptionMenuLabel;
import javapp.tsc.lang.vocab.OtherLabel;

import javax.swing.JPanel;

class RuleHelpChooser extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 564275352023778360L;

	private ChooserComboBox jPanel1;
	private ChooserComboBox jPanel2;

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
				jPanel1 = new ChooserComboBox(OptionMenuLabel.RULE);
				FlowLayout jPanel1Layout = new FlowLayout();
				jPanel1.setLayout(jPanel1Layout);
				this.add(jPanel1);
				jPanel1.setPreferredSize(new java.awt.Dimension(75, 45));
			}
			{
				jPanel2 = new ChooserComboBox(OtherLabel.MOVE);
				FlowLayout jPanel2Layout = new FlowLayout();
				jPanel2.setLayout(jPanel2Layout);
				this.add(jPanel2);
				jPanel2.setPreferredSize(new java.awt.Dimension(88, 45));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
