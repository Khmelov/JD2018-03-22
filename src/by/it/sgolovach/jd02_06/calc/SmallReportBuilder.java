package by.it.sgolovach.jd02_06.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class SmallReportBuilder extends ReportBuilder {


    @Override
    void creatFileLog() {
        ConsoleRunner.logger = Logger.getLogger("smallLog.txt");
    }

    @Override
    void headReport() {
        ConsoleRunner.logger.toLog("Малый отчет калькулятора");
    }

    @Override
    void startPackage() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("ru","RU"));
        Date dateStart=new Date();
        df.format(dateStart);
        ConsoleRunner.logger.toLog(dateStart.toString());
    }

    @Override
    void errorPackage() {
        ConsoleRunner.logger.toLog("ERROR");
    }

    @Override
    void finishPacage() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("ru","RU"));
        Date dateFinish=new Date();
        df.format(dateFinish);
        ConsoleRunner.logger.toLog(dateFinish.toString());
    }
}
