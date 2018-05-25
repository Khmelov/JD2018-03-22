package by.it.fando.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {

    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/fando/jd02_07/Client+XSD.xml";
            String xmlTarget=System.getProperty("user.dir")+"/src/by/it/fando/jd02_09/Client+XSD.xml";

            Clients clients = (Clients) unmarshaller.unmarshal(new File(xmlSource));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter out=new StringWriter();
            marshaller.marshal(clients, out);
            System.out.println(out.toString());

            try (OutputStream outputStream=new FileOutputStream(xmlTarget)){
                marshaller.marshal(clients, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
