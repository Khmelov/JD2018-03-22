package by.it.danilevich.jd02_06_02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private String fileName;
    private PrintWriter printWriter;
    private static Logger instance;


   private Logger() throws IOException {
         fileName = getPath(Logger.class, "log.txt");
         printWriter = new PrintWriter(new FileWriter(fileName),true);
     }

    static Logger getLogger() throws IOException {
        if (instance==null){
            synchronized (Logger.class){
                if (instance==null)
                    instance = new Logger();
            }
        }
        return instance;
    }


    void toLog(String message){
        printWriter.println(message);
    }


    private static String getPath(Class<?> cl,String clName){
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clName;
    }
}
