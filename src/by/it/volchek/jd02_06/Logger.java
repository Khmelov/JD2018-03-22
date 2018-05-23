package by.it.volchek.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by volchek on 15.05.18.
 */
 class Logger {
    private String filename;
    private static Logger instance;

    private Logger(){
        filename = getPath(Logger.class,"log.txt");

    }

    static Logger getLogger (){
        if (instance == null) {
            synchronized (Logger.class){
                if (instance==null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    void toLog (String message) {
        try(PrintWriter printWriter =  new PrintWriter(new FileWriter(filename, true)))
        { printWriter.print(message+'\n'); }
        catch
            (IOException e1) {
            e1.printStackTrace();}
    }









    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;

    }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;

    }
}
