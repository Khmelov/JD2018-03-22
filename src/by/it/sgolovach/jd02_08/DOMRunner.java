package by.it.sgolovach.jd02_08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOMRunner {

    public static void main(String[] args) {

        String filename = "src/by/it/sgolovach/jd02_08/Person.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filename);
            Element element = document.getDocumentElement();
            System.out.println("Start");
            printDom(element);
            System.out.println("Stop");

        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }

    }

    private static String tab = "";

    private static int countTab = 0;

    private static void printDom(Node node) {
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
            printDom(children.item(i));
        }

        if (fd == 1) {
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }
        countTab--;
        if (countTab > 0) tab = tab.substring(1);


    }
}
