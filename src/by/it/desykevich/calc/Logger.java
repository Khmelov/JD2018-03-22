package by.it.desykevich.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static Logger logger;
    private String path=System.getProperty("user.dir")+"/src/by/it/desykevich/calc/";
    private DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);

    private Logger(){}

    public static Logger getLogger(){
        if (logger==null)
            logger= new Logger();
        return logger;
    }

    void logWrite (String text){
        String fileName="log.txt";
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(
                        new File(path, fileName), true))
        ) {
            bw.write(dateFormat.format(new Date()) + ": " + text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
