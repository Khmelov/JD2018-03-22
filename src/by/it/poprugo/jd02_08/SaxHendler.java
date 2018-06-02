package by.it.poprugo.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHendler extends DefaultHandler {

    private String tab = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("START");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("STOP"); // позже закомментировали эту строку
                        //да/нет? (21 мая 20108)
    }

    @Override //тут печатаем начало тега (и его атрибуты в цикле)
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName); // печатаем в начале скобку
        int attCount = attributes.getLength();
        for (int i = 0; i < attCount; i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=\"" + value + "\"");

        }
        System.out.println(">");
        tab = tab + '\t';
    }

    @Override //печатаем конец тега
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String content = text.toString().trim();
        text.setLength(0);
        if (!content.isEmpty())
            System.out.println(tab + content);
        tab = tab.substring(1); //уберем один табулятор
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // накапливаем текст, который к нам "прилетает", чтобы напечатать его в endElement
        String part = new String(ch, start, length);
        text.append(part);
    }

    private StringBuilder text = new StringBuilder();
}
