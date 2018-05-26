package by.it.uskoryaev.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
// do it!
public class XSLTransform {

    private final static String root="src/by/it/uskoryaev/jd02_07/";
    public static void main(String[ ] args) {
        String fileName=root+"BaseFace.xml";
        String fileHTML=root+"BaseFace.html";
        String transform="src/by/it/uskoryaev/jd02_08/transform.xsl";
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
