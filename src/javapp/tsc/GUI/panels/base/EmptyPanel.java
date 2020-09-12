package javapp.tsc.GUI.panels.base;

import java.awt.Color;

import javax.swing.JPanel;

public class EmptyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -78281735499385582L;

	public EmptyPanel() {
		super();
		this.initGUI();
	}

	protected void initGUI() {
		try {
			// this.setPreferredSize(this.getPanelDimension());
			
			this.setBackground(Color.WHITE);
			// this.setOpaque(true);
			
			// TODO: border for debug
			// this.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
			// false));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}