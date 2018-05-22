package by.it.kovko.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTransform {
    public static void main(String[ ] args) {
        String fileName=getPath(XSLTransform.class,"Users.xml");
        String fileHTML=getPath(XSLTransform.class,"Users.html");
        String transform=getPath(XSLTransform.class,"transform.xsl");
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
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;
    }
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path+=(File.separator+"src"+File.separator);
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;
    }
}
