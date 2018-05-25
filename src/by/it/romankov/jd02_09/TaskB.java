package by.it.romankov.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.*;
import java.lang.reflect.Type;

public class TaskB {
    static JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(Agents.class);
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


private static Agents agents;

    static void readXml() throws JAXBException {
        String xmlPath = System.getProperty("user.dir") + "\\src\\by\\it\\romankov\\jd02_09\\Agents1+XSD.xml";
      agents = (Agents) unmarshaller.unmarshal(new File(xmlPath));
    }

    static String getJson(){

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String s = gson.toJson(agents);
        System.out.println(s);
        return s;
    }

    static void readJson(String json) throws JAXBException {

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(agents, sw);
        System.out.println(sw.toString());
    }
    static void saveXml() throws JAXBException {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\nikita\\IdeaProjects\\JD2018-03-22\\src\\by\\it\\romankov\\jd02_09\\resultB.xml"));
            marshaller.marshal(agents, bufferedWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws JAXBException {

readXml();
getJson();
readJson(agents.toString());
saveXml();

    }
}
