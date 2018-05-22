package by.it.verishko.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMRunner {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String fileName = "src/by/it/verishko/jd02_08/Store.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            Element el = doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    static void printDom(String prefix, Node node) {
        String text = node.getNodeValue();
        boolean bool = node.hasAttributes();
        String name = node.getNodeName();
        if (text != null) {
            System.out.println(prefix + text.trim());
            if (bool)
                System.out.print(name);
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix + node.getNodeName() + " > ", children.item(i));
        }
    }
}
