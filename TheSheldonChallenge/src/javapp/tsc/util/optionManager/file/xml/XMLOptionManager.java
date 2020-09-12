/**
 * 
 */
package javapp.tsc.util.optionManager.file.xml;

import java.io.File;

import javapp.tsc.util.XMLSerializerUtil;
import javapp.tsc.util.optionManager.file.FileOptionManager;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import core.tsc.AppCore;
import core.tsc.optionManager.exception.WriteNotSupportedException;

/**
 * @author nikiforos
 * 
 */
public abstract class XMLOptionManager extends FileOptionManager {

	protected static final File DEFAULT_FILE = new File("." + File.separator
			+ "src" + File.separator + "javapp" + File.separator + "tsc"
			+ File.separator + "save" + File.separator + "session.xml");

	public XMLOptionManager() {
		super(DEFAULT_FILE);
	}

	public XMLOptionManager(String path) {
		super(new File(path));
	}

	public XMLOptionManager(File xmlConfigFile) {
		super(xmlConfigFile);
	}

	public boolean writeOptions(AppCore data) throws WriteNotSupportedException {
		// load the document
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(this.configFile);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// enforce consistency before writing
		data.getData().enforceConsistency();

		// write info about players
		final NodeList playerList = doc.getElementsByTagName("player");

		setPlayername(playerList, 1, data.getNameP1());
		setPlayername(playerList, 2, data.getNameP2());

		// write info about options (lang, winScore, rule)
		setOptionInfo(doc, XMLSessionElement.LANGUAGE, data
				.getSessionLanguage().name());
		setOptionInfo(doc, XMLSessionElement.MAX_SCORE,
				Integer.toString(data.getScoreToWin()));
		setOptionInfo(doc, XMLSessionElement.RULE, data.getSessionRule().name());

		XMLSerializerUtil.writeXmlFileViaXSLT(doc, this.configFile);

		return true;
	}

	static final void setPlayername(final NodeList playerList,
			final int playerNumber, String name) {
		playerList.item(playerNumber - 1).getAttributes().getNamedItem("name")
				.setNodeValue(name);
	}

	static final void setOptionInfo(final Document doc,
			final XMLSessionElement elem, String value) {
		doc.getElementsByTagName(elem.elementName()).item(0).getAttributes()
				.getNamedItem("value").setNodeValue(value);
	}
}
