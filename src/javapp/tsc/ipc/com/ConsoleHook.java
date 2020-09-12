package javapp.tsc.ipc.com;

import core.tsc.ipc.communication.DefaultHook;
import core.tsc.ipc.communication.InGameUpdateContext;
import core.tsc.mechanics.gameSession.classic.IClassicGS;
import core.tsc.util.Support;

public final class ConsoleHook extends DefaultHook {
	
	// GameSession data
	private IClassicGS gs;
	
	@Override
	public final void updateUI(final InGameUpdateContext whatToUpdate) {
		switch (whatToUpdate) {
		case SCORE:
		case LABEL:
		case END:
			// TODO: incomplete
			break;
		default:
			// change to UnexpectedContextException
			Support.notImplYet();
			break;
		}
	}
	
	public final IClassicGS getGs() {
		return gs;
	}

	public final void setGs(final IClassicGS gs) {
		this.gs = gs;
	}

}
