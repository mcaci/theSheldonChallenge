package javapp.tsc.GUI.panels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.PanelState;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.ingame.GameOverListener;
import javapp.tsc.GUI.listeners.ingame.PlayerMoveListener;
import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.components.buttons.halfSized.RandomButton;
import javapp.tsc.GUI.panels.components.buttons.halfSized.SurrenderButton;
import javapp.tsc.GUI.panels.components.choicePanel.ClassicChooserPanel;
import javapp.tsc.GUI.panels.components.choicePanel.MoveChooser;
import javapp.tsc.GUI.panels.components.choicePanel.SheldonChooserPanel;
import javapp.tsc.GUI.panels.components.playerInfo.PlayerOneInfoPanel;
import javapp.tsc.GUI.panels.components.playerInfo.PlayerTwoInfoPanel;
import javapp.tsc.core.GUICore;
import javapp.tsc.core.IntercomCore;
import javapp.tsc.mediation.MoveLabelUpdater;
import javapp.tsc.mediation.ScoreLabelUpdater;

import javax.swing.JLabel;

import core.tsc.AppCore;
import core.tsc.rule.Rule;
import core.tsc.rule.ruleSet.IRuleSet;

public final class InGamePanel extends BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2232787911776037654L;
	private RandomButton rb;
	private SurrenderButton sb;
	private PlayerOneInfoPanel p1Panel;
	private PlayerTwoInfoPanel p2Panel;
	private MoveChooser movesPanel;
	private static final int MOVES_PANEL_WIDTH = 180;
	private static final int MOVES_PANEL_HEIGHT = 115;

	// private boolean waitingForChoice = true;
	private IRuleSet moveToReturn;

	private ScoreLabelUpdater guiGSCommunicator;
	private MoveLabelUpdater guiGRCommunicator;

	public InGamePanel(TSCWindow frame) {
		super(frame);

		this.guiGSCommunicator = IntercomCore.getInstance().getGsCom();
		this.guiGSCommunicator.registerInGamePanel(this);
		this.guiGSCommunicator.registerGameOverListener(new GameOverListener(
				this, PanelState.END_GAME));

		this.guiGRCommunicator = IntercomCore.getInstance().getGrCom();
		this.guiGRCommunicator.registerInGamePanel(this);

	}

	protected final void initGUI(TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.IN_GAME);
		try {
			FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0,
					1);
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				{
					p1Panel = new PlayerOneInfoPanel(this, 184, 42);
					this.getMiddlePanel().add(p1Panel);
				}
				{
					p2Panel = new PlayerTwoInfoPanel(this, 184, 42);
					this.getMiddlePanel().add(p2Panel);
				}
				{
					final Dimension dim = new Dimension(MOVES_PANEL_WIDTH,
							MOVES_PANEL_HEIGHT);
					final Point pos = new Point(10, 100);
					final Rule rule = AppCore.getInstance().getSessionRule();
					movesPanel = this.getChooserPanel(dim, pos, rule);
					// safe?? should be...
					this.getMiddlePanel().add((Component) movesPanel);
				}
				{
					rb = new RandomButton(this);
					this.getMiddlePanel().add(rb);
					rb.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 30));
					rb.addActionListener(new PlayerMoveListener(this));
				}
				{
					sb = new SurrenderButton(this);
					this.getMiddlePanel().add(sb);
					sb.setPreferredSize(new java.awt.Dimension(
							GUICore.DEFAULT_PANEL_SIZE.width, 30));
					sb.addActionListener(new PlayerMoveListener(this,
							PanelState.END_GAME));
				}
			}
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private final MoveChooser getChooserPanel(Dimension dim, Point pos,
			Rule rule) {
		switch (rule) {
		default:
		case CLASSIC:
			return new ClassicChooserPanel(dim, pos, this);
		case SHELDON:
			return new SheldonChooserPanel(dim, pos, this);
		}
	}

	// @Override
	// public final void execute() {
	// guiGSCommunicator.updateScoreLabels();
	// }

	public final JLabel getPlayer1Label() {
		return p1Panel.getPlayerLabel();
	}

	public final JLabel getMove1Label() {
		return p1Panel.getMoveLabel();
	}

	public final JLabel getScore1Label() {
		return p1Panel.getScoreLabel();
	}

	public final JLabel getPlayer2Label() {
		return p2Panel.getPlayerLabel();
	}

	public final JLabel getMove2Label() {
		return p2Panel.getMoveLabel();
	}

	public final JLabel getScore2Label() {
		return p2Panel.getScoreLabel();
	}

	// TODO: to remove maybe one day

	public final void setMoveToReturn(IRuleSet moveToReturn) {
		this.moveToReturn = moveToReturn;
	}

	public final IRuleSet getMoveToReturn() {
		return moveToReturn;
	}

}
