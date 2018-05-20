package by.it.kirova.calc;

import java.text.DateFormat;
import java.util.Date;

public class ExtendedReport extends BaseReport {

    @Override
    void addDate(Date date) {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        DateFormat dt = DateFormat.getDateInstance(DateFormat.FULL);
        add(dt.format(date));
    }

    @Override
    protected void addHeader() {
        add("EXTENDED REPORT");
    }

    @Override
    void addException(Exception ex) {
        add(ex.getMessage());
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            add(stackTraceElement.toString());
        }
    }

    @Override
    void print() {
        System.out.println(getMessages());
    }
}
