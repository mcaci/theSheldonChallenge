package javapp.tsc.GUI.frames;

import java.awt.Dimension;

import javapp.tsc.GUI.GUICore;
import javapp.tsc.GUI.panels.base.BasePanel;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class BaseFrame<T extends BasePanel> extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4890156990826966680L;

	/**
	 * panel held by this frame
	 */
	private T currentPanel;
	private Dimension frameDimension;

	public BaseFrame() {
		super();
		BaseFrame.setLookAndFeel();
		this.setFrameDimension(GUICore.DEFAULT_FRAME_SIZE);
		this.setCurrentPanel(null);
		this.initGUI();
	}

	final void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setSize(this.getFrameDimension());
			// this.pack(); // TODO: give a meaning to this method
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void registerPanel(T panel) {
		this.setCurrentPanel(panel);
		this.getContentPane().add(panel);
	}

	static final void setLookAndFeel() {
		try {
			// setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the frameDimension
	 */
	public final Dimension getFrameDimension() {
		return frameDimension;
	}

	/**
	 * @param frameDimension
	 *            the frameDimension to set
	 */
	public final void setFrameDimension(Dimension frameDimension) {
		this.frameDimension = frameDimension;
	}
	
	// TODO: to check
	public final boolean checkIfCurrentPanelIs(Class<T> panelToCheck){
		return this.currentPanel.getClass().equals(panelToCheck);
	}

	/**
	 * @param panel
	 *            the currentPanel to set
	 */
	private final void setCurrentPanel(T panel) {
		this.currentPanel = panel;
	}
}
