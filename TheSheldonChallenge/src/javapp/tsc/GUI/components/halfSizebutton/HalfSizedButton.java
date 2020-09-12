/**
 * 
 */
package javapp.tsc.GUI.components.halfSizebutton;

import java.awt.Dimension;

import javapp.tsc.GUI.components.TSCButton;
import javapp.tsc.GUI.panels.base.BasePanel;

/**
 * @author nikiforos
 * 
 */
public abstract class HalfSizedButton extends TSCButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525210513573821241L;

	/**
	 * @param container
	 * @param name
	 */
	public HalfSizedButton(BasePanel container, String name) {
		super(container, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * app.GUI.panels.components.TSCButton#makeButton(app.GUI.panels.base.BasePanel
	 * )
	 */
	@Override
	protected final void makeButton(BasePanel container, Dimension dim) {
		this.setPreferredSize(dim);
	}
}
