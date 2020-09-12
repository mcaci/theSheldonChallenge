/**
 * 
 */
package core.tsc.lang;

import java.io.File;
import java.util.Locale;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import core.tsc.AppCore;

/**
 * @author nikiforos
 * 
 */
public enum Language {
	ALBANIAN, DUTCH, ENGLISH, FRENCH, GERMAN, ITALIAN, PERSIAN, PORTUGUESE, SPANISH;

	public final Locale getLocaleFromLang() {
		Document vocab = this.loadVocabularyDocument();
		XPathExpression query = null;
		Node node = null;
		final String text = "/vocabulary/@code";
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			query = xpath.compile(text);
			node = (Node) query.evaluate(vocab, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		// process the result
		return new Locale(node.getNodeValue());
	}

	public final Document loadVocabularyDocument() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(this.loadVocabularyFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private final File loadVocabularyFile() {
		String filePath = this.getVocabularyPath();
		return new File(filePath);
	}

	@SuppressWarnings("unused")
	@Deprecated
	private final static String getVocabularyPath(String language_name) {
		String file_extension = ".xml";
		return AppCore.getCurrentPath() + File.separator + "lang"
				+ File.separator + "vocab" + File.separator + "trad"
				+ File.separator + language_name + file_extension;
	}

	private final String getVocabularyPath() {
		String language_name = this.name().toLowerCase();
		String file_extension = ".xml";
		return AppCore.getCurrentPath() + File.separator + "lang"
				+ File.separator + "vocab" + File.separator + "trad"
				+ File.separator + language_name + file_extension;
	}

	public final static String[] getStringVector() {
		Language[] langVect = Language.values();
		String[] stringVect = new String[langVect.length];
		for (int i = 0; i < langVect.length; i++) {
			stringVect[i] = langVect[i].name();
		}
		return stringVect;
	}

	public final static Language defaultElement() {
		return ENGLISH;
	}

}
