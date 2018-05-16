package by.it.kirova.calc;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Logger {

    String loggerPath = null;
    Queue<String> messageBuffer = new LinkedList<>();
    int messageId = 0;
    private static Logger instance;

    static Logger getLogger() {
        if (instance == null)
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        return instance;
    }

    private Logger() {
        loggerPath = Util.getLogPath();
    }

    public enum MessageType {
        USER_INPUT, CALC_OUTPUT, ERROR_MESSAGE
    }

    public void println(String message, MessageType type) {
        println_impl(message, type, true);
    }

    public void println_impl(String message, MessageType type, boolean addToReport) {
        switch (type) {
            case USER_INPUT:
                if(addToReport)
                    BaseReport.getReport().addOperation(type + "\t" + message);
                break;
            case CALC_OUTPUT:
                if(addToReport)
                    BaseReport.getReport().addOperation(type + "\t" + message);
                System.out.println(message);
                break;
            case ERROR_MESSAGE:
                if(addToReport)
                    BaseReport.getReport().addOperation(type + "\t" + message);
                System.err.println(message);
                break;
        }

        printToFile(message, type);
    }

    void printToFile(String message, MessageType type){
        if (loggerPath == null)
            return;

        if (messageBuffer.size() == 50)
            messageBuffer.poll();
        messageBuffer.add(++messageId + ".\t" + type + "\t" + message);

        try (PrintWriter pr = new PrintWriter(new FileWriter(loggerPath))) {
            Iterator<String> iter = messageBuffer.iterator();
            for (String s : messageBuffer) {
                pr.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printErrorMessage(Exception e) {
        BaseReport.getReport().addException(e);
        println_impl(e.getMessage(), MessageType.ERROR_MESSAGE, false);
    }

    public void printErrorStackTrace(Exception e) {
        BaseReport.getReport().addException(e);

        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            sb.append(stackTraceElement).append("\n");
        }
        println_impl(sb.toString(), MessageType.ERROR_MESSAGE, false);
    }

}
