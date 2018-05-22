package by.it.sgolovach.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransform {

    private final static String root = "src/by/it/sgolovach/jd02_08/";

    public static void main(String[] args) {
        String filename = root + "Person.xml";
        String fileHTML = root + "Person.html";
        String transform = "src/by/it/sgolovach/jd02_08/transform.xsl";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(transform));
            transformer.transform(new StreamSource(filename),new StreamResult(fileHTML));
            System.out.println("Transform " + filename + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + filename + " : " + e);
        }
    }

}
