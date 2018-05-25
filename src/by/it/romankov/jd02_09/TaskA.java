package by.it.romankov.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Agents.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String xmlPath=System.getProperty("user.dir")+"/src/by/it/romankov/jd02_07/Agent+XSD.xml";
        Agents agents = (Agents) unmarshaller.unmarshal(new File(xmlPath));
        System.out.println(agents);


        String xmlTarget = System.getProperty("user.dir")+"/src/by/it/romankov/jd02_09/Agents1+XSD.xml";
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter out = new StringWriter();
        m.marshal(agents,out);
        System.out.println(out.toString());

        try(BufferedWriter fr = new BufferedWriter(new FileWriter(xmlTarget))){
            m.marshal(agents, fr);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
