package by.it.desykevich.jd02_09;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskB {
//    public static void main(String[] args) {
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            String xmlSource = System.getProperty("user.dir") + "/src/by/it/desykevich/jd02_07/Users+XSD.xml";
//            String xmlTarget=System.getProperty("user.dir")+"/src/by/it/desykevich/jd02_09/Users+XSD.xml";
//            Users persons = (Users) unmarshaller.unmarshal(new File(xmlSource));
//
//            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
//            String json = gson.toJson(persons);
//            System.out.println(json);
//            Users persons1 = gson.fromJson(json, Users.class);
//
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            StringWriter out=new StringWriter();
//            marshaller.marshal(persons1, out);
//            System.out.println(out.toString());
//
//            try (OutputStream outputStream=new FileOutputStream(xmlTarget)){
//                marshaller.marshal(persons1, outputStream);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//    }
}
