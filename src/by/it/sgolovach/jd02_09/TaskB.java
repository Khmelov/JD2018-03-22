package by.it.sgolovach.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.*;
import java.io.*;

public class TaskB {

    private static String xmlSource = System.getProperty("user.dir") + "/src/by/it/sgolovach/jd02_07/Person+XSD.xml";

    private static String xmlTarget = System.getProperty("user.dir") + "/src/by/it/sgolovach/jd02_09/Person1+XSD.xml";

    private static Unmarshaller unmarshaller;

    private static Marshaller marshaller;

    private static Persons persons, persons1;

    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            readXml();
            String json = getJson();
            System.out.println(json);
            readJson(json);
            marshaller = jaxbContext.createMarshaller();
            saveXml();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void readXml() {
        try {
            persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static String getJson() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(persons);
        return json;
    }

    public static void readJson(String json) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        persons1 = gson.fromJson(json, Persons.class);
    }

    public static void saveXml() {
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter out = new StringWriter();
            marshaller.marshal(persons1, out);
            System.out.println(out.toString());
            try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(persons1, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
