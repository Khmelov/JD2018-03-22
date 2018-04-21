package by.it.kovko.jd01_13;

import java.util.Arrays;
import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try{
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            String name = e.getClass().getName();
            System.out.println("name: "+ name);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.println("class: " + element.getClassName() + "\n" + "line: " + element.getLineNumber());
                    break;
                }
            }
        }


    }
}
