package by.it.kirova.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlToJsonConverter<T> extends AbstractConverter<T> {
    final private Class<T> dataType;

    public XmlToJsonConverter(Class<T> dataType) {
        this.dataType = dataType;
    }

    @Override
    public void load(String s) {
        data = null;
        text = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(dataType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader readerStr = new StringReader(s);
            data = (T) unmarshaller.unmarshal(readerStr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void convert() {
        if (data == null) {
            text = null;
            return;
        }
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        text = gson.toJson(data);
    }
}
