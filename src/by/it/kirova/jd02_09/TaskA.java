package by.it.kirova.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Booking.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/kirova/jd02_07/Booking+XSD.xml";
            String xmlTarget = System.getProperty("user.dir") + "/src/by/it/kirova/jd02_09/Booking+XSD.xml";

            Booking booking = (Booking)unmarshaller.unmarshal(new File(xmlSource));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(booking, System.out);

            try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(booking, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
