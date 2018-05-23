package by.it.kirova.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.*;
import java.io.*;

public class JsonToXmlConverter<T> extends AbstractConverter<T> {
    final private Class<T> dataType;

    public JsonToXmlConverter(Class<T> dataType) {
        this.dataType = dataType;
    }


    @Override
    public void load(String text) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        data = gson.fromJson(text, dataType);
    }

    @Override
    public void convert() {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(dataType);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(data, outputStream);
            text = new String(outputStream.toByteArray());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
