package org.avs.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLHelper {
	private static DocumentBuilderFactory dcBuilderFact = DocumentBuilderFactory.newInstance();
	
	/**
	 * Get the XML file and extract the data from it
	 * @param filepath Path of the XML file
	 * @return Document that represent the XML
	 * @since 27/01/2021
	 */
	public static Document getXmlDocument(String filepath) throws Exception {
		DocumentBuilder builder = dcBuilderFact.newDocumentBuilder();
		return builder.parse(new File(filepath));
	}
	
	/**
	 * Generate an empty XML Document
	 * @return An empty XML Document
	 * @throws ParserConfigurationException if a DocumentBuildercannot be created which satisfies the configuration requested.
	 */
	public static Document emptyDocument() throws ParserConfigurationException {
		return dcBuilderFact.newDocumentBuilder().newDocument();
	}

	/**
	 * Put into a string object the tree view of the XML file
	 * @return The content of the XML into a string object
	 * @throws TransformerException If an unrecoverable error occursduring the course of the transformation
	 * @throws TransformerFactoryConfigurationError Thrown in case of service configuration error or ifthe implementation is not available or cannot be instantiated.
	 * @since 30/01/2021
	 */
	public static String XmlToString(Document xmlDocument) throws TransformerFactoryConfigurationError, TransformerException{
		return XmlToString(xmlDocument, "UTF-8");
	}
	
	/**
	 * 
	 * @param xmlDocument
	 * @param encoding
	 * @return
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	public static String XmlToString(Document xmlDocument, String encoding) throws TransformerFactoryConfigurationError, TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty("encoding", encoding);
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
		return writer.getBuffer().toString();
	}

	/**
	 * Serialize a java object into a XML file. Used basic serialization method of java
	 * @param object   The object to serialize in the files
	 * @param fileName Path of the file where we register the object
	 * @throws FileNotFoundException - if the file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason
	 * @throws IOException If an error occured during using the file
	 * @since 25/01/2021
	 */
	public static void encodeToFile(Object object, String fileName) throws FileNotFoundException, IOException {
		try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName))) { 
			encoder.writeObject(object); 
		} 
	}

	/**
	 * Get the data from a XML file and return the corresponding java object
	 * @param fileName Path of the file deserialize
	 * @return The equivalent object of the XML file
	 * @throws FileNotFoundException if the file does not exist,is a directory rather than a regular file,or for some other reason cannot be opened for reading.
	 * @throws IOException If there is a problem during reading the file
	 */
	public static Object decodeFromFile(String fileName) throws FileNotFoundException, IOException {
		try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName))) { 
			return decoder.readObject(); 
		}  
	}
	
	@Deprecated
	public static Element getRootElement(String filepath) throws Exception{
		DocumentBuilder builder = dcBuilderFact.newDocumentBuilder();
		Document xml = builder.parse(new File(filepath));
		return xml.getDocumentElement();
	}
}
