package by.it.poprugo.jd02_06.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private String filename;
    private static Logger instance;

    private Logger() { filename = getPath(Logger.class, "log_calc.txt"); }

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
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(filename, true))) {
            printWriter.println(message);
                     } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getPath(Class<?> cl) { //cl - ? taskAClass
        String path = System.getProperty("user.dir"); //корень JD018...
        path += File.separator + "src" + File.separator; //чтобы слэш - соответствовал системе
        path += cl.getName() //by.it.poprugo.jd01_14.TaskA
                .replace(cl.getSimpleName(), "") // TaskA = cl.getSimpleName()
                .replace(".", File.separator); //заменили точки на правильные (для нашей с-мы) слэши
        return path;
    }

    private static String getPath(Class<?> cl, String fileName) {
        return getPath(cl) + fileName;
    }

}
