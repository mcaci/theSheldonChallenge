package javapp.tsc.GUI;

import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.panels.MainMenuPanel;

public final class GUIStarter implements Runnable {
	
	// default constructor: not to be seen anywhere else
	GUIStarter() {}

	@Override
	public final void run() {
		final TSCWindow inst = new TSCWindow();
		GUICore.getInstance().setTSCW(inst);

		MainMenuPanel mmp = new MainMenuPanel(inst);
		inst.registerPanel(mmp);
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

}
