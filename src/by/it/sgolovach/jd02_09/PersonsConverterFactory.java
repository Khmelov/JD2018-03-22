package by.it.sgolovach.jd02_09;

import by.it.sgolovach.jd02_09.TaskC.ConverterFactory;
import by.it.sgolovach.jd02_09.TaskC.ConverterJsonToXml;
import by.it.sgolovach.jd02_09.TaskC.ConverterXmlToJson;

public class PersonsConverterFactory implements ConverterFactory {

    @Override
    public ConverterXmlToJson getConverterXmlToJson() {
        return new PersonsConvX_T_J();
    }

    @Override
    public ConverterJsonToXml getConverterJsonToXml() {
        return new PersonsConvJ_T_X();
    }
}
