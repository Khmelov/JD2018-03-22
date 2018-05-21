package by.it.uskoryaev.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXSD {
    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename="src/by/it/uskoryaev/jd02_07/BaseFace+XSD.xml";
        String schemaName="src/by/it/uskoryaev/jd02_07/BaseFace.xsd";
        SchemaFactory schemaFactory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(schemaName);
        try {
            Schema schema=schemaFactory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(filename);
            validator.validate(source);
            System.out.println("Well");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
