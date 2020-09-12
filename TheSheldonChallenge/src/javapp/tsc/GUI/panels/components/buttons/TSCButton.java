/**
 * 
 */
package javapp.tsc.GUI.panels.components.buttons;

import java.awt.Dimension;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.core.GUICore;

import javax.swing.JButton;

/**
 * @author nikiforos
 * 
 */
abstract class TSCButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2402701750576742815L;
	public static final int TSC_BUTTON_WIDTH = GUICore.DEFAULT_PANEL_SIZE.width;
	public static final int TSC_BUTTON_HEIGHT = 40;

	/**
	 * @param name
	 */
	public TSCButton(BasePanel container, String name) {
		super(name);
		Dimension dim = new Dimension(TSC_BUTTON_WIDTH, TSC_BUTTON_HEIGHT);

		// set internal parameters
		this.makeButton(container, dim);
	}

	public TSCButton(BasePanel container, String name, Dimension dim) {
		super(name);

		// set internal parameters
		this.makeButton(container, dim);
	}

	abstract void makeButton(BasePanel container, Dimension dim);

}
