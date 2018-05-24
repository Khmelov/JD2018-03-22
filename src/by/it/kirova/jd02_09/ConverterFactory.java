package by.it.kirova.jd02_09;


public class ConverterFactory {
    public enum ConverterType {
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter<Booking> getConverter(ConverterType type) {
        switch (type) {
            case XML_TO_JSON:
                return new XmlToJsonConverter<>(Booking.class);
            case JSON_TO_XML:
                return new JsonToXmlConverter<>(Booking.class);
            default:
                return null;
        }
    }
}
