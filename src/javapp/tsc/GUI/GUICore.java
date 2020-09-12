/**
 * 
 */
package javapp.tsc.GUI;

import java.awt.Dimension;

import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.panels.InGamePanel;

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

	// TODO: any use?
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
	private GUICore() {}

	public final static GUICore getInstance() {
		return GUICoreHolder.core;
	}

	public final void startGUI() {
		SwingUtilities.invokeLater(new GUIStarter());
	}

	public final GUICore initializeGUI() {
		this.setIgp(null);
		this.setTSCW(null);
		return this;
	}

	@Override
	public final String toString() {
		// return super.toString();
		return "Core instance";
	}

	/**
	 * Used in the GUIStarter
	 */
	final void setTSCW(TSCWindow mw) {
		this.mw = mw;
	}

	/**
	 * Used in the PanelStateTransition listener
	 * @return
	 */
	public final TSCWindow getTSCW() {
		return mw;
	}

	/**
	 * Used in GoButton and RematchButton listeners
	 */
	public final void setIgp(InGamePanel igp) {
		this.igp = igp;
	}

	/**
	 * Used in SwingPlayer
	 * @return
	 */
	public final InGamePanel getIgp() {
		return igp;
	}
}
