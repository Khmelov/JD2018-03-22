package by.it.volchek.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by volchek on 21.05.18.
 */
public class ExeptionHandler {
    static int exeptionNumber;
    static String fileName = "src/by/it/volchek/jd02_06/fileReport.txt";
    private static ExeptionHandler exeptionHandler;

    public static ExeptionHandler getExeptionHandler() {
        if (exeptionHandler == null) {
            exeptionHandler = new ExeptionHandler();
        }
            return exeptionHandler;
    }

    synchronized void handle (Exception exeption, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName,true);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        bufferWriter.write("Ошибка №"+(++exeptionNumber)+':'+'\t'+exeption.toString()+'\n');
        bufferWriter.close();
    }
}
