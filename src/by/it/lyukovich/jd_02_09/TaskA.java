package by.it.lyukovich.jd_02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir")+"/src/by/it/lyukovich/jd_02_07/Books+XSD.xml";
            String xmlTarget=System.getProperty("user.dir")+"/src/by/it/lyukovich/jd_02_09/Books+XSD.xml";

            Books books = (Books) unmarshaller.unmarshal(new File(xmlSource));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter out=new StringWriter();
            marshaller.marshal(books, out);
            System.out.println(out.toString());

            try (OutputStream outputStream=new FileOutputStream(xmlTarget)){
                marshaller.marshal(books, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}