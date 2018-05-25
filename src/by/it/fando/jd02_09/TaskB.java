package by.it.fando.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            marshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Clients clients = readXml();
        String json = getJson(clients);
        Clients resaltB = readJson(json);
        saveXml(resaltB);
    }

    static Unmarshaller unmarshaller;

    private static Clients readXml() {
        String xmlSource = System.getProperty("user.dir") + "/src/by/it/fando/jd02_07/Client+XSD.xml";
        Clients clients = null;
        try {
            clients = (Clients) unmarshaller.unmarshal(new File(xmlSource));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return clients;
    }

    private static Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    private static String getJson(Clients clients) {
        String json = gson.toJson(clients);
        System.out.println(json);
        return json;
    }

    static Marshaller marshaller;

    private static Clients readJson(String json) {
        Clients resaltB = gson.fromJson(json, Clients.class);
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        StringWriter out=new StringWriter();
        try {
            marshaller.marshal(resaltB, out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(out.toString());
        return resaltB;
    }

    private static void saveXml(Clients resaltB) {
        String xmlTarget=System.getProperty("user.dir")+"/src/by/it/fando/jd02_09/ResaltB+XSD.xml";
        try (OutputStream outputStream=new FileOutputStream(xmlTarget)){
            marshaller.marshal(resaltB, outputStream);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
