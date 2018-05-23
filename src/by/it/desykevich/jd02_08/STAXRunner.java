package by.it.desykevich.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class STAXRunner {
    private static String xml = "src/by/it/desykevich/jd02_07/Users+XSD.xml";
    private static String tab="";
    private static StringBuilder text=new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException,XMLStreamException {

        XMLInputFactory factory= XMLInputFactory.newInstance();
        InputStream  stream= new FileInputStream(xml);
        XMLStreamReader parser=factory.createXMLStreamReader(stream);
        while (parser.hasNext()){
            int type=parser.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println(tab+"<"+parser.getLocalName());
                    int attCount = parser.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = parser.getAttributeLocalName(i);
                        String value = parser.getAttributeValue(i);
                        System.out.print(" " + name + "=\"" + value+"\"");
                    }
                    System.out.println(">");
                    tab=tab+'\t';
                    break;

                case XMLStreamConstants.CHARACTERS:
                    text.append(parser.getText());
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    String content = text.toString().trim();
                    text.setLength(0);
                    if (!content.isEmpty())
                        System.out.println(tab+content);
                    tab = tab.substring(1);
                    System.out.println(tab + "</" + parser.getLocalName() + ">");
                    break;


            }
        }


    }
}
