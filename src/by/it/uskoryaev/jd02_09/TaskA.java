package by.it.uskoryaev.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BaseFace.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/uskoryaev/jd02_07/BaseFace+XSD.xml";

            String xmlTarget = System.getProperty("user.dir") + "/src/by/it/uskoryaev/jd02_07/BaseFace+XSD.xml";

            BaseFace baseFace = (BaseFace) unmarshaller.unmarshal(new File(xmlSource));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(baseFace, System.out);

            try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(baseFace, outputStream);

            } catch (IOException e) {
                e.getStackTrace();
            }

            System.out.println(baseFace);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
