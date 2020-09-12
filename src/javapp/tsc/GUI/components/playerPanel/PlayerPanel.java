package javapp.tsc.GUI.components.playerPanel;

import java.awt.Dimension;

import javapp.tsc.GUI.listeners.ingame.WinScoreLabelListener;
import javapp.tsc.GUI.panels.base.BasePanel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import core.tsc.AppCore;
import core.tsc.lang.Language;
import core.tsc.lang.translator.XMLTranslator;
import core.tsc.lang.vocab.OtherLabel;

public abstract class PlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6662513007450351180L;

	protected Dimension dim;
	protected String playerName;
	protected String defaultPlayerName;

	private JLabel playerLabel;
	private JLabel moveLabel;

	private JLabel scoreLabel;
	private JTextField namePlayerTextField;

	public PlayerPanel(BasePanel container, int width, int heigth) {
		super();
		this.dim = new Dimension(width, heigth);
		this.initGUI();
	}

	public void initGUI() {
		this.setPreferredSize(this.dim);
		this.setLayout(null);
		this.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
	}

	protected final void buildInGameInfo() {
		{
			playerLabel = new JLabel();
			this.add(playerLabel);
			playerLabel.setText(playerName);
			playerLabel.setHorizontalAlignment(JLabel.CENTER);
			playerLabel.setSize(this.dim.width, 15);
			playerLabel.setLocation(0, 5);
		}
		{
			moveLabel = new JLabel();
			this.add(moveLabel);
			moveLabel.setText("...");
			moveLabel.setHorizontalAlignment(JLabel.CENTER);
			moveLabel.setSize(this.dim.width / 2, 15);
			moveLabel.setLocation(this.dim.width / 2, 25);
		}
		{
			scoreLabel = new JLabel();
			this.add(scoreLabel);
			scoreLabel.setText("0");
			scoreLabel.setSize(this.dim.width / 2, 15);
			scoreLabel.setLocation(0, 25);
			scoreLabel.setHorizontalAlignment(JLabel.CENTER);
			scoreLabel.addPropertyChangeListener(new WinScoreLabelListener(this));
		}
	}

	protected final void buildInputPlayerInfo() {
		Language currentLang = AppCore.getInstance().getSessionLanguage();
		{
			playerLabel = new JLabel();
			this.add(playerLabel);
			playerLabel.setText(defaultPlayerName);
			playerLabel.setHorizontalAlignment(JLabel.CENTER);
			playerLabel.setSize(this.dim.width, 15);
			playerLabel.setLocation(0, 5);
		}
		{
			final JLabel propmtNameLabel = new JLabel();
			this.add(propmtNameLabel);
			propmtNameLabel.setText(new XMLTranslator().translate(
					OtherLabel.ENTER_NAME, currentLang));
			propmtNameLabel.setHorizontalAlignment(JLabel.CENTER);
			propmtNameLabel.setSize(this.dim.width, 15);
			propmtNameLabel.setLocation(0, 22);
		}
		{
			namePlayerTextField = new JTextField();
			this.add(namePlayerTextField);
			namePlayerTextField.setText(playerName);
			namePlayerTextField.setBounds(5, 40, 170, 20);
		}
	}

	/**
	 * @return the playerLabel
	 */
	public final JLabel getPlayerLabel() {
		return playerLabel;
	}

	/**
	 * @return the moveLabel
	 */
	public final JLabel getMoveLabel() {
		return moveLabel;
	}

	/**
	 * @return the scoreLabel
	 */
	public final JLabel getScoreLabel() {
		return scoreLabel;
	}

	/**
	 * @return the namePlayerTextField
	 */
	public final JTextField getNamePlayerTextField() {
		return namePlayerTextField;
	}

}
