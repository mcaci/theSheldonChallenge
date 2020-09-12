/**
 * 
 */
package core.tsc.player.util;

/**
 * @author nikiforos
 * 
 */
public enum PlayerStatus {
	NOT_A_WINNER, ROUND_WINNER {
		@Override
		public final boolean isRoundWinner() {
			return true;
		}
	},
	GAME_WINNER {
		@Override
		public final boolean isGameWinner() {
			return true;
		}
	},
	SURRENDERED {
		@Override
		public final boolean hasSurrendered() {
			return true;
		}
	};

	public boolean isRoundWinner() {
		return false;
	}

	public boolean isGameWinner() {
		return false;
	}

	public boolean hasSurrendered() {
		return false;
	}
}
