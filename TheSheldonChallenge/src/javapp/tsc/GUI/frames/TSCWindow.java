/**
 * 
 */
package javapp.tsc.GUI.frames;

import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.base.TitledPanel;

import javax.swing.ImageIcon;

/**
 * @author nikiforos
 * 
 */
public class TSCWindow extends BaseFrame<BasePanel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4573216872471723634L;

	public TSCWindow() {
		super();
		this.setTitle("TSC");
		this.setIconImage(new ImageIcon("./javapp/tsc/img/ico/smileJpgIcon.jpg")
				.getImage());
	}

	public static void main(String[] args) {
		TSCWindow testWin = new TSCWindow();
		TitledPanel testPanel = new TitledPanel(testWin) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};
		testWin.registerPanel(testPanel);

		runPanels(testWin);
	}
}