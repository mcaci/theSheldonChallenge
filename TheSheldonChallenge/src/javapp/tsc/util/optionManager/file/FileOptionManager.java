/**
 * 
 */
package javapp.tsc.util.optionManager.file;

import java.io.File;

import core.tsc.optionManager.IOptionManager;

/**
 * @author nikiforos
 * 
 */
public abstract class FileOptionManager implements IOptionManager {

	protected File configFile;

	protected FileOptionManager(File file) {
		this.configFile = file;
	}

}
