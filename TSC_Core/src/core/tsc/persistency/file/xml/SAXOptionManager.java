/**
 * 
 */
package core.tsc.persistency.file.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import core.tsc.AppCore;
import core.tsc.AppCoreData;
import core.tsc.lang.Language;
import core.tsc.persistency.exception.WriteNotSupportedException;
import core.tsc.rule.Rule;

/**
 * @author nikiforos
 * 
 */
public final class SAXOptionManager extends XMLOptionManager {

	String p1Name = null;
	String p2Name = null;
	String langString = null;
	String scoreString = null;
	String ruleString = null;

	public SAXOptionManager() {
		super(DEFAULT_FILE);
	}

	public SAXOptionManager(String path) {
		super(new File(path));
	}

	public SAXOptionManager(File xmlConfigFile) {
		super(xmlConfigFile);
	}

	@Override
	public final AppCoreData readOptions() {

		final SAXParserFactory parseFactory = SAXParserFactory.newInstance();
		try {
			final SAXParser parser = parseFactory.newSAXParser();
			final SAXOptionManagerContentHandler handler = new SAXOptionManagerContentHandler(
					this);
			parser.parse(this.configFile, handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// checking info about options (lang, winScore, rule)
		Language lang = Language.defaultElement();
		try {
			lang = Language.valueOf(this.langString);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			lang = Language.defaultElement();
		}

		int maxScore = 0;
		try {
			maxScore = Integer.parseInt(this.scoreString);
		} catch (NumberFormatException e) {
			maxScore = 0;
		}

		Rule rule = Rule.defaultElement();
		try {
			rule = Rule.valueOf(this.ruleString);
		} catch (IllegalArgumentException e) {
			rule = Rule.defaultElement();
		}

		return new AppCoreData(this.p1Name, this.p2Name, lang, maxScore, rule);
	}

	@Override
	public final boolean writeOptions(AppCore data)
			throws WriteNotSupportedException {
		throw new WriteNotSupportedException(this);
	}

}
