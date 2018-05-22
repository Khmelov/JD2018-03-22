package by.it.danilevich.calc;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {
    static ResourceManager rm;
    static Boolean fullReport;
    private static LogBuilder logBuilder;

    public static void setFullReport(Boolean fullReport) {
        Util.fullReport = fullReport;
    }

    public static Boolean getFullReport() {
        return fullReport;
    }

    public static   LogBuilder getLogBuilder() {
        return logBuilder;
    }

    public static void createLogBuilder() {
        if (getFullReport()){
            logBuilder = new LogFullBuilder();
        }
        else {
            logBuilder =  new LogShortBuilder();
        }
        //logBuilder = logBuilder;
    }

    public static String getPath(Class<?> cl, String clName){
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clName;
    }
    public static String getPathVarsTxt(){
        return getPath(Util.class, "vars.txt");
    }


    static String getPathBundle(Class<?> cl, String nameBundle){
        String path = System.getProperty("user.dir");
        path = cl.getName().replace(cl.getSimpleName(),"");
        path= path+ "ok." + nameBundle;

        return path;
    }

    static String getError(String name){
        return rm.get(name);
    }

    static String getCurrentTime(){
      //  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat2.format(cal.getTime());
    }


    static void putToFileUserAction(String mess, String rez, Boolean err) throws IOException {
        PrintFile printFile = PrintFile.getInstance();


        logBuilder.setMessage(mess);
        logBuilder.setDate(getCurrentTime());
        logBuilder.setResult(rez);
        logBuilder.setErrors(err);

        printFile.setLogBuilder(logBuilder);
        printFile.constructLogger();

        Log logger = printFile.getLogger();
       // System.out.println(logger);
        printFile.toLog(String.valueOf(logger));

    }

    public static void putTitleToFile(String s) throws IOException {
        PrintFile printFile = PrintFile.getInstance();
        //String title = printFile.getLogger().getTitle();//еще не создали
        if (getFullReport()){
            printFile.toLog(s +" Полный отчет "+ getCurrentTime());
        }
        else  printFile.toLog(s +" Краткий отчет "+ getCurrentTime());


    }

}
