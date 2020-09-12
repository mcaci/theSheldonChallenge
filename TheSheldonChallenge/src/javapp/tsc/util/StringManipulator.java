/**
 * 
 */
package javapp.tsc.util;

/**
 * @author nikiforos
 * 
 */
public final class StringManipulator {

	public final static String onlyFirstCharUppercase(String text) {
		return text.substring(0, 1).toUpperCase()
				+ text.substring(1).toLowerCase();
	}

}
