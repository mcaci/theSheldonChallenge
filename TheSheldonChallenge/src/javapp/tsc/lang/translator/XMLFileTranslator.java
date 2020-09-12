package javapp.tsc.lang.translator;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import core.tsc.lang.Language;
import core.tsc.lang.Translatable;

public final class XMLFileTranslator implements TranslateMethod {

	@Override
	public final String translate(Translatable text, Language lang) {
		Document vocab = lang.loadVocabularyDocument();
		XPathExpression query = null;
		Node node = null;
		try {
			query = retrieveQuery(text);
			node = (Node) query.evaluate(vocab, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		// process the result
		return node.getNodeValue();
	}

	private static final XPathExpression retrieveQuery(Translatable text)
			throws XPathExpressionException {
		XPath xpath = XPathFactory.newInstance().newXPath();
		String query = text.getXMLPath() + "text()";
		return xpath.compile(query);
	}

}
