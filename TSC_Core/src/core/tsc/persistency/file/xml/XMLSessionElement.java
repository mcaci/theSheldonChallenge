/**
 * 
 */
package core.tsc.persistency.file.xml;

/**
 * @author nikiforos
 * 
 */
enum XMLSessionElement {
	SESSION, PLAYER, MAX_SCORE, LANGUAGE, RULE;

	public final String elementName() {
		return this.name().toLowerCase();
	}
}
