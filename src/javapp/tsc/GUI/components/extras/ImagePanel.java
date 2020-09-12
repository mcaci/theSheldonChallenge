package javapp.tsc.GUI.components.extras;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author nikiforos
 * 
 */
public final class ImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6960112046296747881L;
	private boolean isAnimation;

	/**
	 * 
	 */
	public ImagePanel(Dimension dim, Point pos, boolean isAnim) {
		this.setAnimation(isAnim);
		this.setPreferredSize(dim);
		this.setLocation(pos);
		this.setLayout(null);
	}

	public final void draw(String filePath) {
		this.addImage(this.getPreferredSize(), filePath, this.isAnimation());
		this.repaint();
	}

	private final void addImage(Dimension dim, String filePath, boolean isAnim) {
		BufferedImage smileAnim = null;
		try {
			smileAnim = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Icon imageIcon = null;
		if (!isAnim) {
			imageIcon = new ImageIcon(smileAnim.getScaledInstance(dim.width,
					dim.height, Image.SCALE_DEFAULT));
		} else {
			imageIcon = new MissingIcon();
		}
		final JLabel picLabel = new JLabel(imageIcon);
		picLabel.setBounds(0, 0, dim.width, dim.height);
		this.add(picLabel);
		// TODO: to change
		// if(isAnim){
		// imageIcon.setImageObserver(picLabel);
		// }
	}

	public final void setAnimation(boolean isAnimation) {
		this.isAnimation = isAnimation;
	}

	public final boolean isAnimation() {
		return isAnimation;
	}
}
