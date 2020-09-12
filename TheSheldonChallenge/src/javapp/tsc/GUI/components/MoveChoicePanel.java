package javapp.tsc.GUI.components;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author nikiforos
 * 
 */
public final class MoveChoicePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6960112046296747881L;

	/**
	 * 
	 */
	public MoveChoicePanel(Dimension dim, Point pos) {
		this.setSize(dim);
		this.setLocation(pos);
		this.setLayout(null);
		this.addContent(dim);
	}

	private final void addContent(Dimension dim) {
		// TODO: use images instead of buttons
		BufferedImage smileAnim = null;
		try {
			smileAnim = ImageIO.read(new File(
					"./src/javapp/tsc/img/moves/sheldon.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel movePicLabel = new JLabel(new ImageIcon(
				smileAnim.getScaledInstance(dim.width, dim.height,
						Image.SCALE_DEFAULT)));
		this.add(movePicLabel);
		movePicLabel.setBounds(0, 0, dim.width, dim.height);
	}

}
