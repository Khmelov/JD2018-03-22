package by.it.kovko.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Report {
    private boolean fullReport;
    private String fileName;
    static private Report instance;

    public String getType() {
        return type;
    }

    private String type;
    private String date;
    private String dateFormat;
    private Report(boolean fullReport, String dateFormat){
        this.dateFormat=dateFormat;
        this.fullReport=fullReport;

        type=(fullReport)?"FullReport":"ShortReport";
        this.fileName=getPath(Logger.class, type+".txt");
        toReport(type); toReport(new SimpleDateFormat(dateFormat).format(new Date()));
    }
    static Report getReport(boolean fullReport, String dateFormat){
        if (instance==null){
            synchronized (Logger.class){
                if (instance==null){
                    instance = new Report(fullReport, dateFormat);
                }
            }
        }
        return instance;
    }

    void toReport(String msg){
        try (PrintWriter pw = new PrintWriter( new FileWriter(fileName,true))){
            pw.write(msg+"\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void toReport(Date date){
        toReport(new SimpleDateFormat(dateFormat).format(date));
    }
    void toReport(Exception exception){
        toReport(exception.getClass().getSimpleName());
        if (fullReport)
            toReport(exception.getMessage());
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
