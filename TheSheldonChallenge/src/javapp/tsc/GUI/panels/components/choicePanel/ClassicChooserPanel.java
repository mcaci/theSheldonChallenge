package javapp.tsc.GUI.panels.components.choicePanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.listeners.ingame.PlayerMoveListener;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.lang.translator.XMLFileTranslator;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.tsc.AppCore;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;

public final class ClassicChooserPanel extends JPanel implements MoveChooser {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7785669935042756994L;

	private ClassicChooserButton rock;
	private ClassicChooserButton paper;
	private ClassicChooserButton scissors;

	public ClassicChooserPanel(Dimension dim, Point pos, InGamePanel self) {
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
				rock = new ClassicChooserButton(ClassicRuleSet.ROCK);
				this.add(rock);
				rock.addActionListener(new PlayerMoveListener(self));
			}
			{
				paper = new ClassicChooserButton(ClassicRuleSet.PAPER);
				this.add(paper);
				paper.addActionListener(new PlayerMoveListener(self));
			}
			{
				scissors = new ClassicChooserButton(ClassicRuleSet.SCISSORS);
				this.add(scissors);
				scissors.addActionListener(new PlayerMoveListener(self));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	final class ClassicChooserButton extends JButton implements ChooserButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = -931835533189332204L;

		ClassicRuleSet correspondingMove;

		public ClassicChooserButton(ClassicRuleSet value) {
			correspondingMove = value;
			setText(new XMLFileTranslator().translate(value, AppCore
					.getInstance().getSessionLanguage()));
		}

		public ClassicRuleSet getCorrespondingMove() {
			return this.correspondingMove;
		}

	}
}
