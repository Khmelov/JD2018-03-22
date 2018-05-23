package by.it.desykevich.Jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {
    private static  String xml="E:\\student\\Desukevich\\JD2018-03-22\\src\\by\\it\\desykevich\\jd02_07\\Persen.xml";

    public static void main(String[] args) throws ParserConfigurationException,SAXException, IOException {
        SAXParserFactory saxParserFactory=SAXParserFactory.newDefaultInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SAXHandler myimplementationSAX=new SAXHandler();
        saxParser.parse(new File(xml),myimplementationSAX);

    }
}
