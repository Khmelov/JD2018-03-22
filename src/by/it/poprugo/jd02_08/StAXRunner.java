package by.it.poprugo.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StAXRunner {
    private static String xml = "src/by/it/poprugo/jd02_07_mine/Order+XSD.xml";
    private static String tab = "";
    private static StringBuilder text = new StringBuilder();

    public static void main(String[] args)
            throws XMLStreamException, FileNotFoundException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        //посмотрели factory.createXMLStreamReader() по точке выбрали InputStreamReader (потому что мы его знаем)
        InputStream stream = new FileInputStream(xml);

        XMLStreamReader parser = factory.createXMLStreamReader(stream);
        while (parser.hasNext()) {
            int type = parser.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT://при START_DOCUMENT - есть либо START либо END

                    //System.out.println("START");
                    /* скопировали из startElement из SaxHendler и подшаманили для своих целей*/
                    System.out.print(tab + "<" + parser.getLocalName()); // печатаем в начале скобку
                    int attCount = parser.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = parser.getAttributeLocalName(i);
                        String value = parser.getAttributeValue(i);
                        System.out.print(" " + name + "=\"" + value + "\"");

                    }
                    System.out.println(">");
                    tab = tab + '\t';
                    break;
// с этого места кое-что "лишнее"? проверить! (21 мая 2018)
                case XMLStreamConstants.ATTRIBUTE:
                    System.out.println("=========");
                    break;

                case XMLStreamConstants.CHARACTERS:
                    parser.getTextCharacters();
                    break;

                //case XMLStreamConstants.END_DOCUMENT:
                case XMLStreamConstants.END_ELEMENT:
                    //System.out.println("END");
                    /* скопировали из endElement из SaxHendler и подшаманили для своих целей
                     */
                    String content = text.toString().trim();
                    text.setLength(0);
                    if (!content.isEmpty())
                        System.out.println(tab + content);
                    tab = tab.substring(1);
                    System.out.println(tab + "</" + parser.getLocalName() + ">");
                    break;
            }
        }
    }
}
