package by.it.kirova.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Logger {

    static String loggerPath = null;
    static Queue<String> messageBuffer = new LinkedList<>();
    static int messageId = 0;

    public enum MessageType {
        USER_INPUT, CALC_OUTPUT, ERROR_MESSAGE
    }

    public static void setLoggerPath(String path) {
        loggerPath = path;
    }

    public static void println(String message, MessageType type) {
        switch (type) {
            case USER_INPUT:
                break;
            case CALC_OUTPUT:
                System.out.println(message);
                break;
            case ERROR_MESSAGE:
                System.err.println(message);
                break;
        }

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

    public static void printErrorMessage(Exception e) {
        println(e.getMessage(), MessageType.ERROR_MESSAGE);
    }

    public static void printErrorStackTrace(Exception e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            sb.append(stackTraceElement).append("\n");
        }
        println(sb.toString(), MessageType.ERROR_MESSAGE);
    }
}
