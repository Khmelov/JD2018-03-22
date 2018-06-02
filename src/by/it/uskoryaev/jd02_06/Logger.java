package by.it.uskoryaev.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private String fileName;

    private Logger() {
        fileName = getPath(Logger.class, "log.txt");
    }

    private static Logger instance;

    static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    void toLog(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String fileName) {
        return getPath(cl) + fileName;
    }
}
