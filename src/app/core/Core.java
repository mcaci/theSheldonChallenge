/**
 * 
 */
package app.core;

/**
 * @author nikiforos
 *
 */
public final class Core {

	/**
	 * private constructor following the Singleton pattern
	 */
	public static Core core;
	
	/**
	 * private constructor following the Singleton pattern
	 */
	private Core(){
	}
	
	public static synchronized Core getInstance(){
		if(core == null){
			return new Core();
		}
		return core;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return super.toString();
		return "Core instance";
	}
}
