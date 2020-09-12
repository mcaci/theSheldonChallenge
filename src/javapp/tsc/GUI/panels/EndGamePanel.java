package javapp.tsc.GUI.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javapp.tsc.GUI.components.button.fullSize.BackButton;
import javapp.tsc.GUI.components.button.fullSize.RematchButton;
import javapp.tsc.GUI.components.extras.ImagePanel;
import javapp.tsc.GUI.components.extras.ScrollableTextArea;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.listeners.newgame.RematchListener;
import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.base.FillerPanel;
import javapp.tsc.GUI.panels.state.PanelState;
import core.tsc.lang.vocab.BackButtonLabel;

public final class EndGamePanel extends BasePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 946676285253951945L;

	private BackButton back;
	private ScrollableTextArea outcomeTA;
	private RematchButton rb;
	private ImagePanel expressionPanel;
	private static final int EXPRESSION_PANEL_SIZE = 100;

	public EndGamePanel(final TSCWindow frame) {
		super(frame);
	}

	protected final void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.END_GAME);
		try {
			final FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0, 2);
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				{
					final Dimension dim = new Dimension(EXPRESSION_PANEL_SIZE,
							EXPRESSION_PANEL_SIZE);
					final Point pos = new Point(40, 7);
					expressionPanel = new ImagePanel(dim, pos, false);
					this.getMiddlePanel().add(expressionPanel);
				}
				{
					final FillerPanel filler = new FillerPanel(4);
					this.getMiddlePanel().add(filler);
				}
				{
					final Dimension dim = new Dimension(164, 66);
					final Point pos = new Point(10, 118);
					outcomeTA = new ScrollableTextArea(dim, pos, new String());
					this.getMiddlePanel().add(outcomeTA);
				}
				{
					final FillerPanel filler = new FillerPanel(5);
					this.getMiddlePanel().add(filler);
				}
				{
					rb = new RematchButton(this);
					this.getMiddlePanel().add(rb);
					rb.addActionListener(new RematchListener(this));
				}
				{
					back = new BackButton(this, BackButtonLabel.MAIN_MENU);
					this.getMiddlePanel().add(back);
					back.addActionListener(new PanelStateTransitionListener(
							this, this.getPanelState().backPanel()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final ScrollableTextArea getOutcomeTextArea() {
		return outcomeTA;
	}

	public final void loadExpressionPath(final String expressionPath) {
		this.expressionPanel.draw(expressionPath);
	}

}
