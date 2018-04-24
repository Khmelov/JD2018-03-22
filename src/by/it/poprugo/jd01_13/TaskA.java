package by.it.poprugo.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("hello");
        }
        /*catch (Exception e) {e.printStackTrace();} - если не знаем, что за ошибку ловим*/ catch (NumberFormatException | NullPointerException e) {
            //String name = e.getClass().getName(); // е - это наш Exeption
            //System.out.println("name: " + name);
            // run
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                /* System.out.println(element); - так можно вывести на экран*/
                if (TaskA.class.getName().equals(element.getClassName())) {
                    /*имя класса в element (ошибка) совпадает с TaskA*/
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    /*информация о классе, в котором возникла ошибка*/
                    int number = element.getLineNumber();
                    /* номер строки, в котором возникла ошибка*/
                    System.out.printf("name:%s\n" +
                            "class:%s\n" +
                            "line:%d\n", name, className, number);
                    break; /*обязательно, чтобы прервать дальнейшее выполнение for*/
                }
            }
            System.out.println("========");
        }
    }
}
