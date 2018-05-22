package by.it.kovko.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Valid {

    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename=getPath(Valid.class,"Users.xml");
        String schemaName =getPath(Valid.class,"Users.xsd");
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println("Valid");

        } catch (SAXException e) {
            System.out.println("Not Valid");
        } catch (IOException e) {
            e.printStackTrace();
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
