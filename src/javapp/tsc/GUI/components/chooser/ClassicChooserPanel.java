package javapp.tsc.GUI.components.chooser;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.listeners.ingame.PlayerMoveListener;
import javapp.tsc.GUI.panels.InGamePanel;
import core.tsc.rule.ruleSet.impl.ClassicRuleSet;

public final class ClassicChooserPanel extends DefaultChooserPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7785669935042756994L;

	public ClassicChooserPanel(Dimension dim, Point pos, InGamePanel container) {
		super(dim, pos, container);
	}

	@Override
	final void placeButtons(InGamePanel container, FlowLayout panelLayout) {
		this.setLayout(panelLayout);
		{
			final ClassicChooserButton rock = new ClassicChooserButton(ClassicRuleSet.ROCK);
			this.add(rock);
			rock.addActionListener(new PlayerMoveListener(container));
		}
		{
			final ClassicChooserButton paper = new ClassicChooserButton(ClassicRuleSet.PAPER);
			this.add(paper);
			paper.addActionListener(new PlayerMoveListener(container));
		}
		{
			final ClassicChooserButton scissors = new ClassicChooserButton(ClassicRuleSet.SCISSORS);
			this.add(scissors);
			scissors.addActionListener(new PlayerMoveListener(container));
		}
	}
}
