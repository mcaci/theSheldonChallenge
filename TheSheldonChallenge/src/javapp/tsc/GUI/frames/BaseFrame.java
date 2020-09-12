package javapp.tsc.GUI.frames;

import java.awt.Dimension;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.core.GUICore;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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

	final static void runPanels(final BaseFrame<?> inst) {
		GUICore.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
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

	/**
	 * @return the currentPanel
	 */
	public final T getCurrentPanel() {
		return currentPanel;
	}

	/**
	 * @param panel
	 *            the currentPanel to set
	 */
	public final void setCurrentPanel(T panel) {
		this.currentPanel = panel;
	}
}
