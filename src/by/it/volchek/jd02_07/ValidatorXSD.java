package by.it.volchek.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by volchek on 17.05.18.
 */
 class ValidatorXSD {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename= "src/by/it/volchek/jd02_07/DoorManufacturer+XSD.xml";
        String schemaName="src/by/it/volchek/jd02_07/DoorManufacturer.xsd";
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println("OK!!!!!");
        }
        catch (SAXException e){
            e.printStackTrace();
            System.out.println("NOT OK!!!");
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("NOT OK AT ALL!!!");
        }
    }
}
