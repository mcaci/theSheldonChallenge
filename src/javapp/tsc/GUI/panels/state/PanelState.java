package javapp.tsc.GUI.panels.state;

import javapp.tsc.GUI.frames.TSCWindow;
import javapp.tsc.GUI.panels.CreditsPanel;
import javapp.tsc.GUI.panels.EndGamePanel;
import javapp.tsc.GUI.panels.InGamePanel;
import javapp.tsc.GUI.panels.InputPlayersPanel;
import javapp.tsc.GUI.panels.MainMenuPanel;
import javapp.tsc.GUI.panels.NewGamePanel;
import javapp.tsc.GUI.panels.OptionsPanel;
import javapp.tsc.GUI.panels.RulesPanel;
import javapp.tsc.GUI.panels.base.BasePanel;
import javapp.tsc.GUI.panels.base.NotReadyPanel;

public enum PanelState {
	CREDITS {
		@Override
		public final PanelState backPanel() {
			return MAIN_MENU;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new CreditsPanel(frame);
		}
	},
	END_GAME {
		@Override
		public final PanelState backPanel() {
			return MAIN_MENU;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new EndGamePanel(frame);
		}
	},
	IN_GAME {
		@Override
		public final PanelState backPanel() {
			return IN_GAME;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new InGamePanel(frame);
		}
	},
	INPUT_PLAYERS {
		@Override
		public final PanelState backPanel() {
			return NEW_GAME;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new InputPlayersPanel(frame);
		}
	},
	MAIN_MENU {
		@Override
		public final PanelState backPanel() {
			return null;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new MainMenuPanel(frame);
		}
	},
	NEW_GAME {
		@Override
		public final PanelState backPanel() {
			return NEW_GAME;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new NewGamePanel(frame);
		}
	},
	OPTIONS {
		@Override
		public final PanelState backPanel() {
			return MAIN_MENU;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new OptionsPanel(frame);
		}
	},
	RULES {
		@Override
		public final PanelState backPanel() {
			return MAIN_MENU;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new RulesPanel(frame);
		}
	},
	NOT_READY {
		@Override
		public final PanelState backPanel() {
			return MAIN_MENU;
		}

		@Override
		public final BasePanel buildPanel(final TSCWindow frame) {
			return new NotReadyPanel(frame);
		}
	};

	public abstract PanelState backPanel();

	public abstract BasePanel buildPanel(final TSCWindow frame);
}
