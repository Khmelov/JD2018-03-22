package by.it.volchek.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMRunner {
    private static String tab="";
    public static void main(String[] args) {
        String FileName = "src/by/it/volchek/jd02_07_test/Person.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            try {
                Document doc = builder.parse(FileName);
                Element element = doc.getDocumentElement();
                printDOM(element);
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static void printDOM(Node node) {
        tab+="\t";
        if (node.getNodeType()==Node.ELEMENT_NODE)
            System.out.println(tab+"<"+node.getNodeName()+">");
        if ((node.getNodeType()==Node.TEXT_NODE) && (!node.getNodeValue().trim().equals("")))
            System.out.println(tab+node.getNodeValue().trim());
        NodeList children = node.getChildNodes();

        for (int i = 0; i <children.getLength() ; i++) {
            printDOM(children.item(i));
        }
        if (node.getNodeType()==Node.ELEMENT_NODE) System.out.println(tab+"</"+node.getNodeName()+">");
        tab=tab.substring(1);
    }
}
