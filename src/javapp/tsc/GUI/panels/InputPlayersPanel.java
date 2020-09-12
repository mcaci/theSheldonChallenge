package javapp.tsc.GUI.panels;

import java.awt.FlowLayout;

import javapp.tsc.GUI.components.button.fullSize.BackButton;
import javapp.tsc.GUI.components.button.halfSize.GoButton;
import javapp.tsc.GUI.components.playerPanel.PlayerOneInputPanel;
import javapp.tsc.GUI.components.playerPanel.PlayerTwoInputPanel;
import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.listeners.newgame.GoButtonListener;
import javapp.tsc.GUI.panels.base.FillerPanel;
import javapp.tsc.GUI.panels.base.TitledPanel;
import javapp.tsc.GUI.panels.state.PanelState;

import javax.swing.JTextField;

import core.tsc.lang.vocab.BackButtonLabel;

public final class InputPlayersPanel extends TitledPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7048427878140063455L;

	private GoButton go;
	private BackButton back;
	private PlayerOneInputPanel player1Panel;
	private PlayerTwoInputPanel player2Panel;

	public InputPlayersPanel(final TSCWindow frame) {
		super(frame);
	}

	protected final void initGUI(final TSCWindow frame) {
		super.initGUI(frame);
		this.setPanelState(PanelState.INPUT_PLAYERS);
		try {
			final FlowLayout middlePanelLayout = new FlowLayout(FlowLayout.CENTER, 0, 1);
			this.getMiddlePanel().setLayout(middlePanelLayout);
			{
				{
					player1Panel = new PlayerOneInputPanel(this, 180, 65);
					this.getMiddlePanel().add(player1Panel);
				}
				{
					player2Panel = new PlayerTwoInputPanel(this, 180, 65);
					this.getMiddlePanel().add(player2Panel);
//					player2Panel.setVisible(false); TODO: remove it
				}
				{
					FillerPanel filler = null;
//					filler = new FillerPanel(70); // WITH ONE PLAYER (to remove?)
					filler = new FillerPanel(5); // WITH TWO PLAYERS
					this.getMiddlePanel().add(filler);
				}
				{
					go = new GoButton(this);
					this.getMiddlePanel().add(go);
					go.addActionListener(new GoButtonListener(this));
				}
				{
					back = new BackButton(this, BackButtonLabel.BACK);
					this.getMiddlePanel().add(back);
					back.addActionListener(new PanelStateTransitionListener(
							this, this.getPanelState().backPanel()));
				}
			}
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	/**
	 * @return the nameP1TextField
	 */
	public final JTextField getNameP1TextField() {
		return this.player1Panel.getNamePlayerTextField();
	}

	/**
	 * @return the nameP2TextField
	 */
	public final JTextField getNameP2TextField() {
		return this.player2Panel.getNamePlayerTextField();
	}

}
