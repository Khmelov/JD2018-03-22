package by.it.sgolovach.jd02_06.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class BigReportBuilder extends ReportBuilder {
    @Override
    void creatFileLog() {
        ConsoleRunner.logger = Logger.getLogger("bigLog.txt");
    }

    @Override
    void headReport() {
        ConsoleRunner.logger.toLog("Большой отчет калькулятора");
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
        ConsoleRunner.logger.toLog(ConsoleRunner.rm.get(Messages.ERROR) + CalcException.class);
    }

    @Override
    void finishPacage() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("ru","RU"));
        Date dateFinish=new Date();
        df.format(dateFinish);
        ConsoleRunner.logger.toLog(dateFinish.toString());
    }
}
