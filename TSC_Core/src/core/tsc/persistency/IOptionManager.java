/**
 * 
 */
package core.tsc.persistency;

import core.tsc.AppCore;
import core.tsc.AppCoreData;
import core.tsc.persistency.exception.ReadNotSupportedException;
import core.tsc.persistency.exception.WriteNotSupportedException;

/**
 * @author nikiforos
 *
 */
public interface IOptionManager {
	
	public abstract AppCoreData readOptions() throws ReadNotSupportedException;
	public abstract boolean writeOptions(AppCore data) throws WriteNotSupportedException;
	
}
