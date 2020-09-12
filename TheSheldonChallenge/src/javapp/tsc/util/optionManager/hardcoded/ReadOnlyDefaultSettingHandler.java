/**
 * 
 */
package javapp.tsc.util.optionManager.hardcoded;

import core.tsc.AppCore;
import core.tsc.AppCoreData;
import core.tsc.optionManager.IOptionManager;
import core.tsc.optionManager.exception.ReadNotSupportedException;
import core.tsc.optionManager.exception.WriteNotSupportedException;

/**
 * @author nikiforos
 * 
 */
public class ReadOnlyDefaultSettingHandler implements IOptionManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javapp.tsc.util.optionManager.IOptionManager#readOptions()
	 */
	@Override
	public AppCoreData readOptions() throws ReadNotSupportedException {
		return new AppCoreData(DefaultSetting.PLAYER_1_NAME.getValue(),
				DefaultSetting.PLAYER_2_NAME.getValue(),
				DefaultSetting.LANGUAGE.getValue(),
				DefaultSetting.MAX_SCORE.getValue(),
				DefaultSetting.RULE.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javapp.tsc.util.optionManager.IOptionManager#writeOptions(javapp.tsc.
	 * core.AppCore)
	 */
	@Override
	public boolean writeOptions(AppCore data) throws WriteNotSupportedException {
		throw new WriteNotSupportedException(this);
	}

}
