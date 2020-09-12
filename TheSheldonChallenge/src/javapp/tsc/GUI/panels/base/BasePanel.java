package javapp.tsc.GUI.panels.base;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.core.GUICore;

import javax.swing.JPanel;

public abstract class BasePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7852678536628252428L;

	private Dimension panelDimension;
	private PanelState panelState;
	private EmptyPanel middlePanel;

	static final void setLookAndFeel() {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BasePanel(TSCWindow frame) {
		super();
		this.initGUI(frame);
		setLookAndFeel();
	}

	protected void initGUI(TSCWindow frame) {
		BorderLayout baseLayout = new BorderLayout();
		this.setLayout(baseLayout);
		this.setPreferredSize(GUICore.DEFAULT_PANEL_SIZE);
		{
			middlePanel = new EmptyPanel();
			this.add(middlePanel, BorderLayout.CENTER);
		}
	}

	/**
	 * @return the panelDimension
	 */
	public final Dimension getPanelDimension() {
		return panelDimension;
	}

	/**
	 * @param panelDimension
	 *            the panelDimension to set
	 */
	public final void setPanelDimension(Dimension panelDimension) {
		this.panelDimension = panelDimension;
	}

	/**
	 * @return the panelState
	 */
	public final PanelState getPanelState() {
		return panelState;
	}

	/**
	 * @param panelState
	 *            the panelState to set
	 */
	public final void setPanelState(PanelState panelState) {
		this.panelState = panelState;
	}

	/**
	 * @return the panel
	 */
	public final EmptyPanel getMiddlePanel() {
		return middlePanel;
	}

	/**
	 * @param middlePanel
	 *            the panel to set
	 */
	public final void setMiddlePanel(EmptyPanel middlePanel) {
		this.middlePanel = middlePanel;
	}

}
