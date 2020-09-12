/**
 * 
 */
package javapp.tsc.GUI.components;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * @author nikiforos
 * 
 */
public final class ScrollableTextArea extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1583322396637380568L;
	private JTextArea textArea;

	/**
	 * 
	 */
	public ScrollableTextArea(Dimension dim, Point pos, String text) {
		this.setPreferredSize(dim);
		this.setLocation(pos);
		this.addTextArea(text);
		this.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
	}

	private final void addTextArea(String text) {
		textArea = new JTextArea();
		this.setViewportView(textArea);

		textArea.setText(text);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new java.awt.Font("Monospaced", 0, 11));
	}

	public final JTextArea getTextArea() {
		return textArea;
	}

}
