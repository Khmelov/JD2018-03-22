package by.it.lyukovich.Calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private String fileName;
    private static Logger instance;
    Logger(){fileName = Util.getPath(Logger.class,"errorlog.txt");}
    static Logger getLogger(){
        if (instance==null){
            synchronized (Logger.class){
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }
    void log(Exception message){
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName,true))){
            printWriter.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
