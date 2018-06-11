package by.it.uskoryaev.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.*;


public class TaskB {
    private static String xmlSource = System.getProperty("user.dir") + "/src/by/it/uskoryaev/jd02_07/BaseFace+XSD.xml";
    private static String xmlTarget = System.getProperty("user.dir") + "/src/by/it/uskoryaev/jd02_09/BaseFace+XSD.xml";

    private static Unmarshaller unmarshaller;
    private static Marshaller marshaller;
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static void main(String[] args) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(BaseFace.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            marshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        BaseFace readXml = readXml();
        String json = getJson(readXml);
        BaseFace baseFace = readJson(json);
        saveXml(baseFace);
    }


    private static BaseFace readXml() {
        BaseFace baseFace = null;
        try {
            baseFace = (BaseFace) unmarshaller.unmarshal(new File(xmlSource));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return baseFace;
    }

    private static String getJson(BaseFace baseFace) {
        String json = gson.toJson(baseFace);
        System.out.println(json);
        return json;
    }

    private static BaseFace readJson(String json) {
        BaseFace baseFace = gson.fromJson(json, BaseFace.class);
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        StringWriter out = new StringWriter();
        try {
            marshaller.marshal(baseFace, out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(out.toString());
        return baseFace;
    }

    private static void saveXml(BaseFace baseFace) {
        try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
            marshaller.marshal(baseFace, outputStream);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
