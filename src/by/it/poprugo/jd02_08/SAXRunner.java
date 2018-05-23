package by.it.poprugo.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {
    // D:\IT\JD_2018\JD2018-03-22\src\by\it\poprugo\jd02_07_mine\Order.xml
    private static String xml = "src/by/it/poprugo/jd02_07_mine/Order+XSD.xml";

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxHendler saxHendler = new SaxHendler();
        saxParser.parse(new File(xml), saxHendler);
    }
}
