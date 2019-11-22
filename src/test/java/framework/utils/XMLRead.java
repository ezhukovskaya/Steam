package framework.utils;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLRead {
    private static final String XMLPATH = "src/test/java/resources/testData.xml";
    static final Logger log = Logger.getLogger(XMLRead.class);

    public static String xmlReader(String key) {
        File file = new File(XMLPATH);
        log.info("Data of " + key + " is read from XML");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            assert documentBuilder != null;
            document = documentBuilder.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        assert document != null;
        return document.getElementsByTagName(key).item(0).getTextContent();
    }
}
