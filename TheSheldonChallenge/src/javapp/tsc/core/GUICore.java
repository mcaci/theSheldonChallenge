/**
 * 
 */
package javapp.tsc.core;

import java.awt.Dimension;

import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.GUI.panels.MainMenuPanel;

import javax.swing.SwingUtilities;

/**
 * @author nikiforos
 * 
 */
public final class GUICore {

	/**
	 * class holder for the Singleton pattern
	 */
	private static class GUICoreHolder {
		public static final GUICore core = new GUICore();
	}

	// TODO: find some way else?
	// private PanelState current;

	// managing changes in windows
	private TSCWindow mw;
	// managing gameplay changes
	private InGamePanel igp;

	public static final Dimension DEFAULT_FRAME_SIZE = new Dimension(194, 292);
	public static final Dimension DEFAULT_PANEL_SIZE = new Dimension(188, 264);

	/**
	 * private constructor following the Singleton pattern
	 */
	private GUICore() {
	}

	public final static GUICore getInstance() {
		return GUICoreHolder.core;
	}

	public final void initializeGUIData() {
		// this.setCurrent(null);
		this.setIgp(null);
		this.setTSCW(null);
	}

	public final static void startGUI() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TSCWindow inst = new TSCWindow();
				GUICore.getInstance().setTSCW(inst);

				MainMenuPanel mmp = new MainMenuPanel(inst);
				inst.registerPanel(mmp);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	@Override
	public final String toString() {
		// TODO Auto-generated method stub
		// return super.toString();
		return "Core instance";
	}

	public final void setTSCW(TSCWindow mw) {
		this.mw = mw;
	}

	public final TSCWindow getTSCW() {
		return mw;
	}

	// public final PanelState getCurrent() {
	// return current;
	// }
	//
	// public final void setCurrent(PanelState current) {
	// this.current = current;
	// }
	//
	public final InGamePanel getIgp() {
		return igp;
	}

	public final void setIgp(InGamePanel igp) {
		this.igp = igp;
	}
}
