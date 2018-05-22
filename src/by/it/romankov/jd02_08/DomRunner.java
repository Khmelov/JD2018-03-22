package by.it.romankov.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomRunner {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String fileName = "C:\\Users\\nikita\\IdeaProjects\\JD2018-03-22\\src\\by\\it\\romankov\\jd02_07\\Agent+XSD.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(fileName);
        org.w3c.dom.Element el=doc.getDocumentElement();
        printDom("", (Node) el);
    }
        static void printDom(String prefix, Node node) {
            String text=node.getNodeValue();

            NamedNodeMap Attribute = node.getAttributes();
            boolean b = node.hasAttributes();
           String name = node.getNodeName();
            if (text!=null ) {
                System.out.println(prefix + text.trim());
                if(b)
                    System.out.print(name);
            }
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printDom(prefix+node.getNodeName() + " > ", children.item(i));
            }
        }

    }

