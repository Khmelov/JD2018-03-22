package by.it.sgolovach.jd02_09;

import by.it.sgolovach.jd02_09.TaskC.ConverterJsonToXml;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

public class PersonsConvJ_T_X implements ConverterJsonToXml {

    private static String xmlTarget = System.getProperty("user.dir") + "/src/by/it/sgolovach/jd02_09/TaskC/ResultConv.xml";

   private static Marshaller marshaller;

    private static Persons persons1;

    private static StringWriter out;

    @Override
    public void readJson() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        persons1 = gson.fromJson(PersonsConvX_T_J.json, Persons.class);

    }

    @Override
    public void saveXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            out = new StringWriter();
            marshaller.marshal(persons1, out);
            try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(persons1, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printXml() {
        System.out.println(out.toString());
    }
}
