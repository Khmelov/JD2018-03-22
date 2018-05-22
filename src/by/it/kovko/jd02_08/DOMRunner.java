package by.it.kovko.jd02_08;

import com.sun.org.apache.xpath.internal.NodeSet;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMRunner {
    static private String xml = getPath(DOMRunner.class,"Users.xml");
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xml);
//        Element document = doc.getDocumentElement();
//        document.normalize();
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        getXML(doc);
    }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;
    }
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path+=(File.separator+"src"+File.separator);
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;
    }
    private static String append = "";
    private static void getXML(Node node){
        if (node.hasChildNodes()) {
            Node n;
            int l = node.getChildNodes().getLength();
            for (int i = 0; i < l; i++) {
                n = node.getChildNodes().item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.print(append+"<"+n.getNodeName());
                    if (n.hasAttributes()){
                        // NamedNodeMap не гарантирует такого же порядка аттрибутов
                        NamedNodeMap attributes = n.getAttributes();
                        int lAttr= attributes.getLength();
                        for (int j = 0; j < lAttr; j++) {
                            Node attribute = attributes.item(j);
                            System.out.print(" "+attribute.getNodeName()
                                            +"=\""+attribute.getNodeValue()+"\"");
                        }
                    }
                    System.out.println(">");
                    append=append+"\t";
                    getXML(n);
                    append=append.substring(1);
                    System.out.println(append+"</"+n.getNodeName()+">");
                } else if (n.getNodeType() == Node.TEXT_NODE){
                    if (!n.getTextContent().matches("[\\s]*")) {
                        System.out.println(append+"\t" + n.getTextContent().trim());
                    }
                } else {
                    System.out.println(n.getNodeType());
                }
            }
        } else {
            System.out.println(node.getTextContent());
        }
    }
}
