package by.it.verishko.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/verishko/jd02_07/Store/Store+XSD.xml";
            String xmlTarget = System.getProperty("user.dir") + "/src/by/it/verishko/jd02_07/Store/Store1+XSD.xml";
            Persons persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(persons);
            System.out.println(json);
            Persons persons1 = gson.fromJson(json, Persons.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter out = new StringWriter();
            marshaller.marshal(persons1, System.out);
            System.out.println(out.toString());

            try (
                    OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(persons, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
