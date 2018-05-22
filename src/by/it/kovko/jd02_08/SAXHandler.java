package by.it.kovko.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    private String tab="";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.print(tab+"<"+qName);
        int count = attributes.getLength();
        for (int i = 0; i < count; i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" "+name+"=\""+value+"\"");
        }
        System.out.println(">");
        tab = tab + "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String content = text.toString().trim();
        text.setLength(0);
        if (!content.isEmpty())
            System.out.println(tab+content);
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");

    }

    private StringBuilder text = new StringBuilder();
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String (ch,start,length));
    }
}
