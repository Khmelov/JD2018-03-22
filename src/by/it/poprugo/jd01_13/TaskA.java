package by.it.poprugo.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else Integer.parseInt("привет");
        } catch (RuntimeException e) {
            StackTraceElement[] stackTraceElement = e.getStackTrace();
            for (StackTraceElement element : stackTraceElement) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.println("name: " + e.getClass().getName() +
                            "\nclass: " + element.getClassName() +
                            "\nline: " + element.getLineNumber());
                }
            }
        }
    }
}
