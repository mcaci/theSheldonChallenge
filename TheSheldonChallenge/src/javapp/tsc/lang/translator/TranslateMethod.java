package javapp.tsc.lang.translator;

import core.tsc.lang.Language;
import core.tsc.lang.Translatable;

public interface TranslateMethod {

	public String translate(Translatable text, Language lang);

}
