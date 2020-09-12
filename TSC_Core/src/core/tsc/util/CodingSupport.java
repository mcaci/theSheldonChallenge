package core.tsc.util;

public final class CodingSupport {
	
	private CodingSupport(){}
	
	public final static String onlyFirstCharUppercase(String text) {
		return text.substring(0, 1).toUpperCase()
				+ text.substring(1).toLowerCase();
	}
	
	public static final void notImplYet(){
		try{
			throw new Exception("Not implemented yet");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
