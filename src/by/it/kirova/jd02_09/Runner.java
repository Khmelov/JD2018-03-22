package by.it.kirova.jd02_09;

import java.io.File;

public class Runner {
    public static void main(String[] args) {

        ConverterFactory cf = new ConverterFactory();
        AbstractConverter<Booking> converter = cf.getConverter(ConverterFactory.ConverterType.XML_TO_JSON);
        String xmlInputPath = System.getProperty("user.dir") + "/src/by/it/kirova/jd02_07/Booking+XSD.xml";
        String jsonOutputPath = System.getProperty("user.dir") + "/src/by/it/kirova/jd02_09/Booking+XSD.json";
        String xmlOutputPath = System.getProperty("user.dir") + "/src/by/it/kirova/jd02_09/Booking+XSD.xml";
        File xmlSource = new File(xmlInputPath);
        File xmlTarget = new File(xmlOutputPath);
        File jsonTarget = new File(jsonOutputPath);
        converter.load(xmlSource);
        converter.convert();
        converter.save(jsonTarget);

        converter = cf.getConverter(ConverterFactory.ConverterType.JSON_TO_XML);
        converter.load(jsonTarget);
        converter.convert();
        converter.save(xmlTarget);
    }
}
