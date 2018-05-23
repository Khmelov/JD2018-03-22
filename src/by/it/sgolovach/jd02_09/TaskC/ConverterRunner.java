package by.it.sgolovach.jd02_09.TaskC;

import by.it.sgolovach.jd02_09.PersonsConverterFactory;

public class ConverterRunner {
    public static void main(String[] args) {
        ConverterFactory converterFactory = new PersonsConverterFactory();
        ConverterXmlToJson converterXmlToJson = converterFactory.getConverterXmlToJson();
        ConverterJsonToXml converterJsonToXml = converterFactory.getConverterJsonToXml();

        System.out.println("Start programm");

        converterXmlToJson.readXml();
        converterXmlToJson.getJson();
        converterXmlToJson.printJson();

        converterJsonToXml.readJson();
        converterJsonToXml.saveXml();
        converterJsonToXml.printXml();
    }
}
