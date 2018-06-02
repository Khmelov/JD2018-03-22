package by.it.poprugo.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;*/

public class TaskB {
    public static void main(String[] args) throws JAXBException {

        //скопировали кусок из TaskA

        JAXBContext jaxbContent = JAXBContext.newInstance(Persons.class);
        Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
        String xmlSource = System.getProperty("user.dir") + "/src/by/it/poprugo/jd02_07/Person+XSD.xml";
        String xmlTarget = System.getProperty("user.dir") + "/src/by/it/poprugo/jd02_07/Person+XSD.xml";
        Persons persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(persons);
        System.out.println(json);
        //Persons persons1 = gson.fromJson().Persons;
        Persons persons1 = gson.fromJson(json, Persons.class);


        Marshaller marshaller = jaxbContent.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter out = new StringWriter();
        marshaller.marshal(persons1, out);
        System.out.println(out.toString());

    }

}
