package by.it.volchek.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by volchek on 19.05.18.
 */
public class SAXRunner {
    private static String xml="src/by/it/volchek/jd02_07_test/Person.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SAXHandler sh = new SAXHandler();
        saxParser.parse(new File(xml), sh );



    }
}
