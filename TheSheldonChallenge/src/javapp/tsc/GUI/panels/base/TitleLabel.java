package javapp.tsc.GUI.panels.base;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TitleLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1235413444033671343L;

	private static final String GAME_TITLE = "The Sheldon Challenge";
	private static final int WIDTH = 200;
	private static final int HEIGHT = 45;
	private static final Dimension TITLE_DIM = new Dimension(WIDTH, HEIGHT);

	public TitleLabel() {
		this.setText(GAME_TITLE);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setPreferredSize(TITLE_DIM);
		// set opaque lets me display the color
		this.setOpaque(true);
		this.setBackground(Color.WHITE);

		// Border stays for debug purposes
		// this.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1,
		// false));
	}

}
