package javapp.tsc.GUI.components.choicePanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.listeners.ingame.PlayerMoveListener;
import javapp.tsc.GUI.panels.InGamePanel;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.tsc.AppCore;
import core.tsc.lang.translator.XMLFileTranslator;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

public final class SheldonChooserPanel extends JPanel implements MoveChooser {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6300521191142338224L;

	private SheldonChooserButton rock;
	private SheldonChooserButton paper;
	private SheldonChooserButton scissors;
	private SheldonChooserButton lizard;
	private SheldonChooserButton spock;

	public SheldonChooserPanel(Dimension dim, Point pos, InGamePanel self) {
		super();
		initGUI(dim, pos, self);
	}

	private void initGUI(Dimension dim, Point pos, InGamePanel self) {
		try {
			this.setPreferredSize(dim);
			// this.setLocation(pos);

			FlowLayout panelLayout = new FlowLayout();
			this.setLayout(panelLayout);
			{
				rock = new SheldonChooserButton(SheldonRuleSet.ROCK);
				this.add(rock);
				rock.addActionListener(new PlayerMoveListener(self));
			}
			{
				paper = new SheldonChooserButton(SheldonRuleSet.PAPER);
				this.add(paper);
				paper.addActionListener(new PlayerMoveListener(self));
			}
			{
				scissors = new SheldonChooserButton(SheldonRuleSet.SCISSORS);
				this.add(scissors);
				scissors.addActionListener(new PlayerMoveListener(self));
			}
			{
				lizard = new SheldonChooserButton(SheldonRuleSet.LIZARD);
				this.add(lizard);
				lizard.addActionListener(new PlayerMoveListener(self));
			}
			{
				spock = new SheldonChooserButton(SheldonRuleSet.SPOCK);
				this.add(spock);
				spock.addActionListener(new PlayerMoveListener(self));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	final class SheldonChooserButton extends JButton implements ChooserButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = -931835533189332204L;

		SheldonRuleSet correspondingMove;

		public SheldonChooserButton(SheldonRuleSet value) {
			correspondingMove = value;
			setText(new XMLFileTranslator().translate(value, AppCore
					.getInstance().getSessionLanguage()));
		}

		public SheldonRuleSet getCorrespondingMove() {
			return this.correspondingMove;
		}

	}

}
