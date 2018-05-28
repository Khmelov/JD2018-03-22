package by.it.desykevich.jd02_09;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {

    public static void main(String[] args) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource=System.getProperty("user.dir")+"/src/by/it/desykevich/jd02_07/Users+XSD.xml";
            String xmlTarget=System.getProperty("user.dir")+"/src/by/it/desykevich/jd02_09/Users+XSD.xml";

            Users users = (Users) unmarshaller.unmarshal(new File(xmlSource));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter out=new StringWriter();
            marshaller.marshal(users, out);
            System.out.println(out.toString());

            try (OutputStream outputStream=new FileOutputStream(xmlTarget)){
                marshaller.marshal(users, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }


}
