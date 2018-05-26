package by.it.uskoryaev.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TaskB {
    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BaseFace.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/uskoryaev/jd02_07/BaseFace+XSD.xml";

            String xmlTarget = System.getProperty("user.dir") + "/src/by/it/uskoryaev/jd02_07/BaseFace+XSD.xml";

            BaseFace baseFace = (BaseFace) unmarshaller.unmarshal(new File(xmlSource));
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(baseFace);
            System.out.println(json);

            gson.fromJson(json,BaseFace.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(baseFace,System.out);

            try (OutputStream outputStream = new FileOutputStream(xmlTarget)){
                marshaller.marshal(baseFace,outputStream);

            }catch (IOException e){
                e.getStackTrace();
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}