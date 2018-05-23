package by.it.sgolovach.jd02_09;

import by.it.sgolovach.jd02_09.TaskC.ConverterXmlToJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class PersonsConvX_T_J implements ConverterXmlToJson {

    private static String xmlSource = System.getProperty("user.dir") + "/src/by/it/sgolovach/jd02_07/Person+XSD.xml";

    private static Unmarshaller unmarshaller;

    private static Persons persons;

    public static String json;

    @Override
    public void readXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));
            System.out.println(persons.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getJson() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        json=gson.toJson(persons);
    }

    @Override
    public void printJson() {
        System.out.println(json);
    }
}
