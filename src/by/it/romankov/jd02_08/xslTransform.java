package by.it.romankov.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class xslTransform {


    private final static String root="src/by/it/romankov/jd02_07/";
    public static void main(String[ ] args) {
        String fileName=root+"Agent.xml";
        String fileHTML=root+"Agent.html";
        String transform="src/by/it/romankov/jd02_08/transformer.xsl";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(transform));
            transformer.transform(new StreamSource(fileName),
            new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }

}
