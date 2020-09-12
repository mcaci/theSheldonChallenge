package javapp.tsc.GUI.components.ruleHelp;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

final class RuleHelpTable extends javax.swing.JPanel {

	/**
	 * TODO: not yet implemented
	 */
	private static final long serialVersionUID = -3583102541699688015L;

	private JTable helpTable;

	public RuleHelpTable() {
		super();

		try {
			throw new Exception("Not yet Implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}

		initGUI();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			{
				// Fill table
				String[] columnNames = null;// TODO:
											// OutcomeMessage.getStringVector();
				// TODO: to complete
				String[][] data = new String[][] { { "One", "Two" },
						{ "Three", "Four" }, { "Three", "Four" } };
				TableModel defaultModel = new DefaultTableModel(data,
						columnNames);
				helpTable = new JTable();

				// adding Table Header
				this.add(helpTable, BorderLayout.CENTER);
				this.add(helpTable.getTableHeader(), BorderLayout.PAGE_START);
				this.add(helpTable, BorderLayout.CENTER);

				helpTable.setModel(defaultModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
