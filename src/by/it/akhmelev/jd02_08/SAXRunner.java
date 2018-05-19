package by.it.akhmelev.jd02_08;

import org.xml.sax.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {
    private static String xml = "src/by/it/akhmelev/jd02_07/Person+XSD.xml";

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxHandler saxHandler = new SaxHandler();
        saxParser.parse(new File(xml), saxHandler);
    }
}
