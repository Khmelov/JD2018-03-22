package by.it.uskoryaev.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("src/by/it/uskoryaev/jd02_07/BaseFace.xml"));

        Element element = document.getDocumentElement();

        printD(element);

    }
    private static String tab = "";
    private static int countTab = 0;

     private static void printD(Node node) {
        if (countTab > 0) tab = tab + "\t";
        countTab++;
        String text = node.getNodeValue();
        if (text != null) {
            System.out.println(tab+text.trim());
        }
        int fd = node.getNodeType();
        if (fd == 1) {
            System.out.print(tab + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap namedNodeMap = node.getAttributes();
                System.out.print(" ");
                for (int i = 0; i < namedNodeMap.getLength(); i++) {
                    System.out.print(namedNodeMap.item(i));
                }
                System.out.println(">");
            } else System.out.println(">");
        }


        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {print(children.item(i));}
        if (fd == 1) {
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }
        countTab--;
        if (countTab > 0) tab = tab.substring(1);


    } private static void print(Node node) {
        if (countTab > 0) tab = tab + "\t";
        countTab++;
        String text = node.getNodeValue();
        if (text != null) {
            System.out.println(tab+text.trim());
        }
        int fd = node.getNodeType();
        if (fd == 1) {
            System.out.print(tab + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap namedNodeMap = node.getAttributes();
                System.out.print(" ");
                for (int i = 0; i < namedNodeMap.getLength(); i++) {
                    System.out.print(namedNodeMap.item(i));
                }
                System.out.println(">");
            } else System.out.println(">");
        }


        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            print(children.item(i));
        }
        if (fd == 1) {
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }
        countTab--;
        if (countTab > 0) tab = tab.substring(1);
    }

}
