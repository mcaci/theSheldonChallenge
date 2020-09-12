package javapp.tsc.GUI.components.chooser;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.listeners.ingame.PlayerMoveListener;
import javapp.tsc.GUI.panels.InGamePanel;
import core.tsc.rule.ruleSet.impl.SheldonRuleSet;

public final class SheldonChooserPanel extends DefaultChooserPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6300521191142338224L;

	public SheldonChooserPanel(Dimension dim, Point pos, InGamePanel self) {
		super(dim, pos, self);
	}

	@Override
	final void placeButtons(InGamePanel container, FlowLayout panelLayout) {
		this.setLayout(panelLayout);
		{
			final SheldonChooserButton rock = new SheldonChooserButton(SheldonRuleSet.ROCK);
			this.add(rock);
			rock.addActionListener(new PlayerMoveListener(container));
		}
		{
			final SheldonChooserButton paper = new SheldonChooserButton(SheldonRuleSet.PAPER);
			this.add(paper);
			paper.addActionListener(new PlayerMoveListener(container));
		}
		{
			final SheldonChooserButton scissors = new SheldonChooserButton(SheldonRuleSet.SCISSORS);
			this.add(scissors);
			scissors.addActionListener(new PlayerMoveListener(container));
		}
		{
			final SheldonChooserButton lizard = new SheldonChooserButton(SheldonRuleSet.LIZARD);
			this.add(lizard);
			lizard.addActionListener(new PlayerMoveListener(container));
		}
		{
			final SheldonChooserButton spock = new SheldonChooserButton(SheldonRuleSet.SPOCK);
			this.add(spock);
			spock.addActionListener(new PlayerMoveListener(container));
		}
	}

}
