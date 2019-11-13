package utils.propertiesManager;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLRead {
    private static String xmlFilePath = "src/test/resources/testData.xml";
    private static String downloadPath;
    private static File xmlFile = new File(xmlFilePath);
    public static String xmlReader() {
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(xmlFile);
                document.getDocumentElement().normalize();
                NodeList fileDownloadPath = document.getElementsByTagName("Path");
                for (int i = 0; i < fileDownloadPath.getLength(); i++) {
                    Node node = fileDownloadPath.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        downloadPath = element.getElementsByTagName("Path").item(0).getTextContent();
                    }
                }
            }catch (ParserConfigurationException e){
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch(SAXException e){
                System.out.println(e.getMessage());
            }
            return downloadPath;
    }
}
