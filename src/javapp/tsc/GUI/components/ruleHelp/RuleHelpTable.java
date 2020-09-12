package javapp.tsc.GUI.components.ruleHelp;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

public final class RuleHelpTable extends JPanel {

	/**
	 * TODO: not yet implemented
	 */
	private static final long serialVersionUID = -3583102541699688015L;
	private JTable helpTable;

	public RuleHelpTable() {
		super();
		this.initGUI();
	}

	private final void initGUI() {
		try {
			final BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new Dimension(160, 70));
			this.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			{
				// adding Table Header
				this.helpTable = new JTable();
				this.add(this.helpTable, BorderLayout.CENTER);
				this.add(this.helpTable.getTableHeader(), BorderLayout.PAGE_START);
				this.add(this.helpTable, BorderLayout.CENTER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setModel(TableModel defaultModel) {
		this.helpTable.setModel(defaultModel);
	}
}
