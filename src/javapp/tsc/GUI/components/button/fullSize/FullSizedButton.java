/**
 * 
 */
package javapp.tsc.GUI.components.button.fullSize;

import java.awt.Dimension;

import javapp.tsc.GUI.components.button.TSCButton;
import javapp.tsc.GUI.panels.base.BasePanel;

/**
 * @author nikiforos
 * 
 */
public abstract class FullSizedButton extends TSCButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7995231969554290305L;

	/**
	 * @param container
	 * @param name
	 */
	public FullSizedButton(BasePanel container, String name) {
		super(container, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * app.GUI.panels.components.TSCButton#makeButton(app.GUI.panels.base.BasePanel)
	 */
	@Override
	protected final void makeButton(BasePanel container, Dimension dim) {
		this.setPreferredSize(dim);
	}
}
