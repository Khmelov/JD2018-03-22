package by.it.verishko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

class Logger {

    private String filename;

    private static Logger instance;

    private Logger(String filename) {
        filename = getPath(Logger.class, "log.txt");
    }

    static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
//                if (instance == null)
//                    instance = new Logger();
            }
        }
        return instance;
    }

    void toLog(String message) {
//        try (PrintWriter printWriter = new PrintWriter(new FileWriter()));
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
