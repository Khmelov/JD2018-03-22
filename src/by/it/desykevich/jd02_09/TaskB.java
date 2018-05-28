package by.it.desykevich.jd02_09;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskB {

    public static void main(String[] args) throws JAXBException {
        readXml();
        getJson();
        readJson(users.toString());
        saveXml();
    }


    private static Users users;

    static void readXml() throws JAXBException {
        String xmlPath = System.getProperty("user.dir") + "\\src\\by\\it\\desykevich\\jd02_09\\Users+XSD.xml";
        users = (Users) unmarshaller.unmarshal(new File(xmlPath));
    }

    static String getJson(){

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String js = gson.toJson(users);
        System.out.println(js);
        return js;
    }

    static void readJson(String json) throws JAXBException {

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(users, sw);
        System.out.println(sw.toString());
    }

    static void saveXml() throws JAXBException {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter
                    ("E:\\student\\Desukevich\\JD2018-03-22\\src\\by\\it\\desykevich\\jd02_09\\ResultB.xml"));
            marshaller.marshal(users, bufferedWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(Users.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static Unmarshaller unmarshaller;

    static {
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static Marshaller marshaller;

    static {
        try {
            marshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
