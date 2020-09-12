/**
 * 
 */
package core.tsc.optionManager;

import core.tsc.AppCore;
import core.tsc.AppCoreData;
import core.tsc.optionManager.exception.ReadNotSupportedException;
import core.tsc.optionManager.exception.WriteNotSupportedException;

/**
 * @author nikiforos
 *
 */
public interface IOptionManager {
	
	public abstract AppCoreData readOptions() throws ReadNotSupportedException;
	public abstract boolean writeOptions(AppCore data) throws WriteNotSupportedException;
	
}
