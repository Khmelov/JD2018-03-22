package by.it.poprugo.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskB {
    public static void main(String[] args) throws JAXBException {

   //скопировали кусок из TaskA

    JAXBContext jaxbContent = JAXBContext.newInstance(Persons.class);
    Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
    String xmlSource = System.getProperty("user.dir") + "/src/by/it/poprugo/jd02_07/Person+XSD.xml";
    String xmlTarget = System.getProperty("user.dir") + "/src/by/it/poprugo/jd02_07/Person+XSD.xml";
    Persons persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));

    Gson gson = GsonBuilder().serializeNulls().setPrettyPrinting().create();
    String json = gson.toGson(persons);
        System.out.println(json);
        //Persons persons1 = gson.fromJson.Persons
    }

}
