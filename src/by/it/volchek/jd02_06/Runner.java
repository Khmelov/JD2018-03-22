package by.it.volchek.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * Created by volchek on 21.05.18.
 */
public class Runner {

    public static void main(String[] args) throws IOException {
        String fileName = "src/by/it/volchek/jd02_06/fileReport.txt";
        FileWriter file = new FileWriter(fileName);
        ExeptionFactory exeptionFactory = new ExeptionFactory();
        for (int i = 0; i < 20 ; i++) {
            try {
                exeptionFactory.generateExeption(ExeptionGenerator.generate());
            } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException | StringIndexOutOfBoundsException exeption) {
                ExeptionHandler.getExeptionHandler().handle(exeption, fileName);
            }
        }
    }
}
