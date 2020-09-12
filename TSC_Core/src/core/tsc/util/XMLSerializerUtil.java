/**
 * 
 */
package core.tsc.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * @author nikiforos
 * 
 */
public final class XMLSerializerUtil {

	public static final void writeXmlFileViaXerces(Document doc, File xmlFile) {
		try {
			final FileWriter xmlFileWriter = new FileWriter(xmlFile);
			final XMLSerializer ser = new XMLSerializer();
			ser.setOutputCharStream(xmlFileWriter);
			ser.serialize(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final void writeXmlFileViaXSLT(Document doc, File xmlFile) {
		try {
			// Prepare the DOM document for writing
			final Source source = new DOMSource(doc);

			// Prepare the output file
			final Result result = new StreamResult(xmlFile);

			// Write the DOM document to the file
			final Transformer xformer = TransformerFactory.newInstance()
					.newTransformer();
			xformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
