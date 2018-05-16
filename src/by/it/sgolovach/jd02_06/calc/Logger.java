package by.it.sgolovach.jd02_06.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {


    private String filename;
    private static Logger instance;

    Logger(String nameFile) {
        filename = getPath(Logger.class, nameFile);

    }

    static Logger getLogger(String namefile) {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger(namefile);
            }
        }
        return instance;
    }

    void toLog(String message) {
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(filename, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }
}
