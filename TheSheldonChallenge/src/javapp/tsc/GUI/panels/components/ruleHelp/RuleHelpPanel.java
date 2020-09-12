/**
 * 
 */
package javapp.tsc.GUI.panels.components.ruleHelp;

import javapp.tsc.lang.translator.XMLFileTranslator;
import javapp.tsc.lang.vocab.OtherMessage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import core.tsc.AppCore;
import core.tsc.lang.Language;

/**
 * @author nikiforos
 * 
 */
public final class RuleHelpPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -723166127228229282L;

	private RuleHelpChooser jPanel1;
	private RuleHelpTable jTable1;
	private JLabel jLabel1;

	public RuleHelpPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			SpringLayout lm = new SpringLayout();
			// this.setPreferredSize(new java.awt.Dimension(10, 20));
			this.setLayout(lm);
			{
				jPanel1 = new RuleHelpChooser();
				this.add(jPanel1);
			}
			{
				jTable1 = new RuleHelpTable();
				this.add(jTable1);
				// jTable1.setBorder(new LineBorder(new java.awt.Color(0,0,0),
				// 1, false));
			}
			{
				Language currentLang = AppCore.getInstance()
						.getSessionLanguage();
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText(new XMLFileTranslator().translate(
						OtherMessage.TIE, currentLang) + "*");
			}
			{
				// positioning table
				lm.putConstraint(SpringLayout.NORTH, jPanel1, 10,
						SpringLayout.NORTH, this);
				lm.putConstraint(SpringLayout.HORIZONTAL_CENTER, jPanel1, 0,
						SpringLayout.HORIZONTAL_CENTER, this);
				// positioning table
				lm.putConstraint(SpringLayout.NORTH, jTable1, 10,
						SpringLayout.SOUTH, jPanel1);
				lm.putConstraint(SpringLayout.HORIZONTAL_CENTER, jTable1, 0,
						SpringLayout.HORIZONTAL_CENTER, jPanel1);
				// positioning label
				lm.putConstraint(SpringLayout.NORTH, jLabel1, 10,
						SpringLayout.SOUTH, jTable1);
				lm.putConstraint(SpringLayout.HORIZONTAL_CENTER, jLabel1, 0,
						SpringLayout.HORIZONTAL_CENTER, jTable1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
