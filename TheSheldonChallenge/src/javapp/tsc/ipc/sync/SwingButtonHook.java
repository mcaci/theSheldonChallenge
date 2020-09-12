package javapp.tsc.ipc.sync;

import javapp.tsc.player.impl.human.SwingPlayer;
import core.tsc.ipc.ISynchro;
public class SwingButtonHook implements ISynchro {
	
	public SwingButtonHook(SwingPlayer player) {}
	
	@Override
	public synchronized void holdIt() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	synchronized public final void resume(){
		this.notify();
	}


}
