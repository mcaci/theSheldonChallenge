package javapp.tsc.GUI.panels.base;

import javapp.tsc.GUI.GUICore;

import javax.swing.Box.Filler;

public class FillerPanel extends Filler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8504041267340266990L;

	public FillerPanel(int height) {
		super(
				new java.awt.Dimension(GUICore.DEFAULT_PANEL_SIZE.width, 0),
				new java.awt.Dimension(GUICore.DEFAULT_PANEL_SIZE.width, height),
				new java.awt.Dimension(GUICore.DEFAULT_PANEL_SIZE.width, height));
	}

}
