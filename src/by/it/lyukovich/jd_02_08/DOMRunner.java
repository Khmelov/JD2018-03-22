package by.it.lyukovich.jd_02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMRunner {

    private static String xml = "src/by/it/lyukovich/jd_02_07/Books.xml";
    private static String tab="";
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        document = builder.parse(xml);
        Element root = document.getDocumentElement();
        print(root);
    }

    private static void print(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(tab + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.print(" "+attribute.getNodeName()+"=\""+attribute.getNodeValue()+"\"");
                }
            }
            System.out.println(">");
        }
        if ((node.getNodeType() == Node.TEXT_NODE) && (!node.getNodeValue().trim().isEmpty())){
            System.out.println(tab + node.getNodeValue().trim());
        }
        if ((node.getNodeType() == Node.CDATA_SECTION_NODE)) {
            System.out.println(tab + node.getNodeValue().trim());
        }
        tab = tab + "\t";
        NodeList child = node.getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            print(child.item(i));
        }
        tab = tab.substring(1);
        if (node.getNodeType() == Node.ELEMENT_NODE)
            System.out.println(tab + "</" + node.getNodeName() + ">");
    }
}
