package by.it.volchek.jd01_13;

import java.util.HashMap;

/**
 * Created by volchek on 19.04.18.
 */
public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NumberFormatException|NullPointerException e) {
            //String name = e.getClass().getName();
            //e.printStackTrace();
            //System.out.println("Ghbdtn");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
        if (TaskA.class.getName().equals(element.getClassName()))
        {
            String name =e.getClass().getName();
            String className = element.getClassName();
            int number = element.getLineNumber();
            System.out.printf("name: %s \n" + "class: %s \n"+ "line: %d", name, className, number);
            break;
        }
            //  System.out.println(stackTraceElement);
            }
        }
    }
}
