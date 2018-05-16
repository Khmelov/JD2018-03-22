package by.it.kovko.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private String fileName;

    private Logger(){
        this.fileName=getPath(Logger.class, "log.txt");
    }
    private static Logger instance;
    static Logger getLogger(){
        if (instance==null){
            synchronized (Logger.class){
                if (instance==null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    void toLog(String msg){
        try (PrintWriter pw = new PrintWriter( new FileWriter(fileName,true))){
            pw.write(msg+"\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;
    }
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path+=(File.separator+"src"+File.separator);
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;
    }
}
