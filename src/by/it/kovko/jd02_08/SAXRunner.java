package by.it.kovko.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXRunner {
    static private String xml = getPath(SAXRunner.class,"Users.xml");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SAXHandler saxHandler = new SAXHandler();
        saxParser.parse(new File(xml), saxHandler);


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
