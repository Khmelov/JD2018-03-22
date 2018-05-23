package by.it.danilevich.jd02_06;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A customer ordering a product.
 */
public class TaskC {
    public static void main(String[] args) throws IOException {
        PrintFile printFile = PrintFile.getInstance();

        String message="";
        String dateFull="";
        String DateShort="";
        String result="";
        String type = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String time = dateFormat.format(cal.getTime());

        if (Math.random() > 0.5) {
            type = "full";
            printFile.toLog("Полный отчет "+time);
        }
        else {
            type = "short";
            printFile.toLog("Краткий отчет "+time);
        }


        LogBuilder logBuilder = type.equals("short") ? new LogShortBuilder() :
                new LogFullBuilder();

        logBuilder.setMessage("Adding 1+2");
        logBuilder.setDate(dateFormat2.format(cal.getTime()));
        logBuilder.setResult("2");
        logBuilder.setErrors(true);

        printFile.setLogBuilder(logBuilder);
        printFile.constructLogger();

        Log logger = printFile.getLogger();
      //  printFile.t
        System.out.println(logger);
        printFile.toLog(String.valueOf(logger));
    }
}
