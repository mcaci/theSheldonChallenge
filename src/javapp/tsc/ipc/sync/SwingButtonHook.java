package javapp.tsc.ipc.sync;

import javapp.tsc.player.impl.human.SwingPlayer;
import core.tsc.ipc.IGameSynchro;

public class SwingButtonHook implements IGameSynchro {
	
	public SwingButtonHook(final SwingPlayer player) {}
	
	@Override
	public synchronized final void holdIt() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized final void resume(){
		this.notify();
	}


}
