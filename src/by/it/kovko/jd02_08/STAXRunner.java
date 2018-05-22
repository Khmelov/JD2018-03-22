package by.it.kovko.jd02_08;

import com.sun.xml.internal.bind.v2.util.XmlFactory;

import javax.print.DocFlavor;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class STAXRunner {
    static private String xml = getPath(SAXRunner.class,"Users.xml");
    static private String tab="";
    static private StringBuilder text = new StringBuilder();
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        InputStream input = new FileInputStream(xml);
        XMLStreamReader parser =  factory.createXMLStreamReader(input);
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        while(parser.hasNext()){
            int type = parser.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    System.out.print(tab+"<"+parser.getLocalName());
                    int count = parser.getAttributeCount();
                    for (int i = 0; i < count; i++) {
                        String name = parser.getAttributeLocalName(i);
                        String value = parser.getAttributeValue(i);
                        System.out.print(" "+name+"=\""+value+"\"");
                    }
                    System.out.println(">");
                    tab = tab + "\t";break;
                    case XMLStreamConstants.END_ELEMENT:
                        String content = text.toString().trim();
                        text.setLength(0);
                        if (!content.isEmpty())
                            System.out.println(tab+content);
                        tab=tab.substring(1);
                        System.out.println(tab+"</"+parser.getLocalName()+">");break;
                    case XMLStreamConstants.CHARACTERS:
                        text.append(parser.getText());break;
            }
        }
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
}
