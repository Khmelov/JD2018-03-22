package by.it.kirova.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.*;
import java.io.*;


public class TaskB {
    static JAXBContext jaxbContext;
    static Unmarshaller unmarshaller;
    static Marshaller marshaller;
    static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static void main(String[] args) {
        try {
            jaxbContext = JAXBContext.newInstance(Booking.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            marshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Booking booking = readXml();
        String json = getJson(booking);
        Booking booking1= readJson(json);
        saveXml(booking1);
    }


    public static Booking readXml() {
        Booking booking = null;
        try {
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/kirova/jd02_07/Booking+XSD.xml";
            booking = (Booking) unmarshaller.unmarshal(new File(xmlSource));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return booking;
    }

    public static String getJson(Booking booking) {
        String json = gson.toJson(booking);
        System.out.println(json);
        return json;
    }

    public static Booking readJson(String json) {
        Booking booking1 = gson.fromJson(json, Booking.class);
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        StringWriter out = new StringWriter();
        try {
            marshaller.marshal(booking1, out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(out.toString());
        return booking1;
    }

    public static void saveXml(Booking booking1) {
        String xmlTarget = System.getProperty("user.dir") + "/src/by/it/kirova/jd02_09/Booking+XSD.xml";
        try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
            marshaller.marshal(booking1, outputStream);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}


