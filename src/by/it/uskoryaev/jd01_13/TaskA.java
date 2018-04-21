package by.it.uskoryaev.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) new HashMap<String, String>(null);
            else Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                if (TaskA.class.getName().equals(stackTraceElement.getClassName())) {
                    System.out.println("name: "+e.getClass().getName());
                    System.out.println("class: "+stackTraceElement.getClassName());
                    System.out.println("line: "+stackTraceElement.getLineNumber());
                    break;
                }
            }

        }
    }
}
