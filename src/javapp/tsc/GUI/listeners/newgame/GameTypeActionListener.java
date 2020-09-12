/**
 * 
 */
package javapp.tsc.GUI.listeners.newgame;

import java.awt.event.ActionEvent;

import javapp.tsc.GUI.components.button.fullSize.OnePlayerButton;
import javapp.tsc.GUI.components.button.fullSize.PlayerButton;
import javapp.tsc.GUI.components.button.fullSize.TwoPlayersButton;
import javapp.tsc.GUI.listeners.PanelStateTransitionListener;
import javapp.tsc.GUI.panels.NewGamePanel;
import javapp.tsc.GUI.panels.state.PanelState;
import javapp.tsc.ipc.com.SwingLabelHook;
import core.tsc.AppCore;
import core.tsc.ipc.IntercomCore;
import core.tsc.mechanics.GameType;
import core.tsc.player.exception.NoPlayerNameException;
import core.tsc.player.exception.UnknownRuleException;

/**
 * @author nikiforos
 * 
 */
public final class GameTypeActionListener extends
		PanelStateTransitionListener {

	public GameTypeActionListener(final NewGamePanel self) {
		super(self, PanelState.INPUT_PLAYERS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public final void actionPerformed(final ActionEvent arg0) {
		
		final PlayerButton source = (PlayerButton) arg0.getSource();
		
		// TODO: incomplete (still?)
		try {
			setHooks(source);
		} catch (NoPlayerNameException e) {
			e.printStackTrace();
		} catch (UnknownRuleException e) {
			e.printStackTrace();
		}

		super.actionPerformed(arg0);
	}

	private final void setHooks(PlayerButton source) throws NoPlayerNameException, UnknownRuleException {
		
		IntercomCore.getInstance().setHook(new SwingLabelHook());
		if(source instanceof TwoPlayersButton) {
			AppCore.getInstance().getData().setTypeOfGame(GameType.PLAYER_VS_PLAYER);
		}
		else if(source instanceof OnePlayerButton) {
			AppCore.getInstance().getData().setTypeOfGame(GameType.PLAYER_VS_AI);
			AppCore.getInstance().getData().setNameP2(AppCore.DEFAULT_NAME_P2);
		}
		else { //TODO: else if(source instanceof ZeroPlayerButton) {
			AppCore.getInstance().getData().setTypeOfGame(GameType.AI_VS_AI);
		}
		
	}
}
