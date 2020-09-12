/**
 * 
 */
package javapp.tsc.util.optionManager.file.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import core.tsc.AppCore;
import core.tsc.AppCoreData;
import core.tsc.lang.Language;
import core.tsc.optionManager.exception.ReadNotSupportedException;
import core.tsc.optionManager.exception.WriteNotSupportedException;
import core.tsc.rule.Rule;

/**
 * @author nikiforos
 * 
 */
public final class DOMOptionManager extends XMLOptionManager {

	public DOMOptionManager() {
		super(DEFAULT_FILE);
	}

	public DOMOptionManager(String path) {
		super(new File(path));
	}

	public DOMOptionManager(File xmlConfigFile) {
		super(xmlConfigFile);
	}

	@Override
	public final AppCoreData readOptions() throws ReadNotSupportedException {
		// load the document
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(this.configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO: what if xml file has invalid data?

		// read info about players
		final NodeList playerList = doc.getElementsByTagName("player");

		final String p1Name = getPlayername(playerList, 1);
		final String p2Name = getPlayername(playerList, 2);

		// read info about options (lang, winScore, rule)
		final String langString = getOptionInfo(doc, XMLSessionElement.LANGUAGE);
		Language lang = Language.defaultElement();
		try {
			lang = Language.valueOf(langString);
		} catch (IllegalArgumentException e) {
			lang = Language.defaultElement();
		}

		final String scoreString = getOptionInfo(doc,
				XMLSessionElement.MAX_SCORE);
		int maxScore = 0;
		try {
			maxScore = Integer.parseInt(scoreString);
		} catch (NumberFormatException e) {
			maxScore = 0;
		}

		final String ruleString = getOptionInfo(doc, XMLSessionElement.RULE);
		Rule rule = Rule.defaultElement();
		try {
			rule = Rule.valueOf(ruleString);
		} catch (IllegalArgumentException e) {
			rule = Rule.defaultElement();
		}

		return new AppCoreData(p1Name, p2Name, lang, maxScore, rule);
	}

	@Override
	public final boolean writeOptions(AppCore dataToFile)
			throws WriteNotSupportedException {
		return super.writeOptions(dataToFile);
	}

	private static final String getPlayername(final NodeList playerList,
			final int playerNumber) {
		return playerList.item(playerNumber - 1).getAttributes()
				.getNamedItem("name").getNodeValue();
	}

	private static final String getOptionInfo(final Document doc,
			final XMLSessionElement elem) {
		return doc.getElementsByTagName(elem.elementName()).item(0)
				.getAttributes().getNamedItem("value").getNodeValue();
	}
}
