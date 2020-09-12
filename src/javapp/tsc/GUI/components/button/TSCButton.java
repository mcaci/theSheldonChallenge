/**
 * 
 */
package javapp.tsc.GUI.components.button;

import java.awt.Dimension;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.GUI.panels.base.BasePanel;

import javax.swing.JButton;

/**
 * @author nikiforos
 * 
 */
public abstract class TSCButton extends JButton {

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
		final Dimension dim = new Dimension(TSC_BUTTON_WIDTH, TSC_BUTTON_HEIGHT);

		// set internal parameters
		this.makeButton(container, dim);
	}

	public TSCButton(BasePanel container, String name, Dimension dim) {
		super(name);

		// set internal parameters
		this.makeButton(container, dim);
	}

	protected abstract void makeButton(BasePanel container, Dimension dim);

}
