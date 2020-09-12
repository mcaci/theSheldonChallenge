/**
 * 
 */
package core.tsc.ipc;

/**
 * 
 * 
 * @author nikiforos
 * 
 */
public final class IntercomCore {
	
	private IHook hook;

	/**
	 * private constructor following the Singleton pattern
	 */
	private IntercomCore() {
		this.setHook(null);
	}

	/**
	 * class holder for the Singleton pattern
	 */
	private static class IntercomCoreHolder {
		public static final IntercomCore core = new IntercomCore();
	}

	public static final IntercomCore getInstance() {
		return IntercomCoreHolder.core;
	}

	@Override
	public final String toString() {
		return super.toString();
	}

	public void setHook(IHook hook) {
		this.hook = hook;
	}

	public IHook getHook() {
		return hook;
	}
}