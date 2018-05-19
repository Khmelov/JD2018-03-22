package by.it.kirova.calc;

import java.text.DateFormat;
import java.util.Date;

public class ShortReport extends BaseReport {

    @Override
    void addDate(Date date) {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        DateFormat dt = DateFormat.getDateInstance(DateFormat.FULL);
        add(dt.format(date));
    }

    @Override
    protected void addHeader() {
        add("SHORT REPORT");
    }

    @Override
    void addException(Exception ex) {
        add(ex.getMessage());
    }

    @Override
    void print() {
        System.out.println(getMessages());
    }
}
