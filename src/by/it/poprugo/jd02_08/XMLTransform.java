package by.it.poprugo.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLTransform {
    //использование XPath преобразованиях XSL
    private final static String root="src/by/it/poprugo/jd02_07_mine/";
    public static void main(String[ ] args) {
        String fileName=root+"Order.xml";
        String fileHTML=root+"Order.html";
        String transform="src/by/it/poprugo/jd02_08/transform.xsl";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(transform));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}
