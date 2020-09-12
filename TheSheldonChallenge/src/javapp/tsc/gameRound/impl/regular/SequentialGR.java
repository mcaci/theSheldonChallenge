/**
 * 
 */
package javapp.tsc.gameRound.impl.regular;

import javapp.tsc.gameSession.impl.regular.RoundBasedGS;

/**
 * @author nikiforos
 */
public class SequentialGR extends TwoPlayersRound {

	public SequentialGR(RoundBasedGS info) {
		super(info);
	}

	@Override
	public void run() {

		// TODO: to remove
		try {
			throw new Exception("Not implemented yet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// PHASE 1: prompt for choice

		// PHASE 2: collects moves and resolves round

		// PHASE 2.1: update gui

		// PHASE 3: update roundWinners
	}

}
