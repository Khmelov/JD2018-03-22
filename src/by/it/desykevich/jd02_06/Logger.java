package by.it.desykevich.jd02_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static Logger logger;
    private String path = System.getProperty("user.dir")+"/src/by/it/desykevich/jd02_06/";
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

    private Logger() {

    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        try {
            for (int i = 0; i < 10; i++) {
                String line = "line number ";
                System.out.println(line + i);
                logger.logWrite(line + i);

            }
            int n = 2/0;
            logger.logWrite(Integer.valueOf(n).toString());
        } catch (Exception e) {
            logger.logWrite(e.getMessage());
        }
    }

    private static Logger getLogger() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    private void logWrite(String text) {
        String fileName = "log.txt";
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
