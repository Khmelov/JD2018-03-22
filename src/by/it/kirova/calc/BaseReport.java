package by.it.kirova.calc;

import java.util.*;

public abstract class BaseReport {
    abstract void addDate(Date date);
    protected abstract void addHeader();
    void addOperation(String result) {
        add(result);
    }
    abstract void addException(Exception ex);
    abstract void print();

    private StringBuilder stringBuilder = new StringBuilder();
    protected void add(String message){
        stringBuilder.append(message + "\n");
    }
    protected String getMessages(){
        return stringBuilder.toString();
    }

    protected BaseReport(){
        addHeader();
    }

    private static BaseReport instance;
    static BaseReport getReport() {
        if (instance == null){
            synchronized (BaseReport.class) {
                if (instance == null){
                    Random rnd = new Random();
                    if(rnd.nextInt() % 2 == 0){
                        instance = new ShortReport();
                    } else {
                        instance = new ExtendedReport();
                    }
                }
            }
        }
        return instance;
    }
}
