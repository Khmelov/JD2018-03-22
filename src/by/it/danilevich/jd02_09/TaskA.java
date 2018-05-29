package by.it.danilevich.jd02_09;

import by.it.akhmelev.jd02_09.Persons;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/akhmelev/jd02_07/Person+XSD.xml";
            String xmlTarget=System.getProperty("user.dir")+"/src/by/it/akhmelev/jd02_09/Person+XSD.xml";

            Persons persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter out=new StringWriter();
            marshaller.marshal(persons, out);
            System.out.println(out.toString());

            try (OutputStream outputStream=new FileOutputStream(xmlTarget)){
                marshaller.marshal(persons, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
