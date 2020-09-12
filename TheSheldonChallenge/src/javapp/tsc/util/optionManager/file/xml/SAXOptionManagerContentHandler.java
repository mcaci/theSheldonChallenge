package javapp.tsc.util.optionManager.file.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

final class SAXOptionManagerContentHandler extends DefaultHandler {

	private int playerNumber = 1;
	private SAXOptionManager container = null;

	private int counter = 0;

	public SAXOptionManagerContentHandler(SAXOptionManager container) {
		super();
		this.container = container;
		this.playerNumber = 1;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);

		// TODO: to change in the future
		properReader(qName, attributes);
		// fastReader(attributes.getValue(0));
	}

	private void properReader(String qName, Attributes attributes) {
		final String elemName = qName;

		if (elemName.equals("player")) {
			// TODO: check that playerNumber doens't work in a strange way
			switch (this.playerNumber) {
			case 1:
				this.container.p1Name = attributes.getValue(0);
				playerNumber++; // gets to 2
				break;
			case 2:
				this.container.p2Name = attributes.getValue(0);
				playerNumber--; // gets to 1
				break;
			default:
				break;
			}
		} else if (elemName.equals("max_score")) {
			this.container.scoreString = attributes.getValue(0);
		} else if (elemName.equals("language")) {
			this.container.langString = attributes.getValue(0);
		} else if (elemName.equals("rule")) {
			this.container.ruleString = attributes.getValue(0);
		} else {
			// do nothing
		}

	}

	/**
	 * To remove whenever session.xml/dtd changes!!!... totally unreliable
	 * 
	 * @param attrValue
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void fastReader(String attrValue) {

		switch (this.counter) {
		case 0:
			this.container.p1Name = attrValue;
			counter++; // gets to 1
			break;
		case 1:
			this.container.p2Name = attrValue;
			counter++; // gets to 2
			break;
		case 2:
			this.container.scoreString = attrValue;
			counter++; // gets to 3
			break;
		case 3:
			this.container.langString = attrValue;
			counter++; // gets to 4
			break;
		case 4:
			this.container.ruleString = attrValue;
			counter = 0; // reset counter
			break;
		default:
			break;
		}
	}
}
