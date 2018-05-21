package by.it.kirova.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser {
    private static String tab = "";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String FileName = "src/by/it/kirova/jd02_07/Booking.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        builder = factory.newDocumentBuilder();
        doc = builder.parse(FileName);
        Element root = doc.getDocumentElement();
        printer(root);
    }

    private static void printer(Node node) {

        if (node.getNodeType() == Node.ELEMENT_NODE)
            System.out.println(tab + "<" + node.getNodeName() + ">");
        if ((node.getNodeType() == Node.TEXT_NODE) && (!node.getNodeValue().trim().isEmpty()))
            System.out.println(tab + node.getNodeValue().trim());

        tab = tab + "\t";

        NodeList child= node.getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            printer(child.item(i));
        }

        tab = tab.substring(1);

        if (node.getNodeType() == Node.ELEMENT_NODE)
            System.out.println(tab + "</" + node.getNodeName() + ">");


    }
}

