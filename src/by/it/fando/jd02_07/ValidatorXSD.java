package by.it.fando.jd02_07;

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
        String file="src/by/it/fando/jd02_07/Client+XSD.xml";
        String schema="src/by/it/fando/jd02_07/Client.xsd";
        SchemaFactory schemaFactory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(schema);
        try {
            Schema schemaNew=schemaFactory.newSchema(schemaLocation);
            Validator validator=schemaNew.newValidator();
            Source source=new StreamSource(file);
            validator.validate(source);
            System.out.println("VALID");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
