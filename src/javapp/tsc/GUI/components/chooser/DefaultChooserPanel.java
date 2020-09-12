package javapp.tsc.GUI.components.chooser;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.panels.InGamePanel;

import javax.swing.JPanel;

public abstract class DefaultChooserPanel extends JPanel implements IChooserPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4281486065973544874L;
	
	DefaultChooserPanel(Dimension dim, Point pos, InGamePanel self) {
		super();
		this.initGUI(dim, pos, self);
	}

	abstract void placeButtons(InGamePanel self, FlowLayout panelLayout);

	void initGUI(Dimension dim, Point pos, InGamePanel container) {
		this.setPreferredSize(dim);
		// this.setLocation(pos);
		FlowLayout panelLayout = new FlowLayout();
		this.placeButtons(container, panelLayout);
	}

}
