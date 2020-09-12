/**
 * 
 */
package core.tsc.persistency.file;

import java.io.File;

import core.tsc.persistency.IOptionManager;

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
