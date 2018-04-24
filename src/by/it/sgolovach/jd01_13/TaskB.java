package by.it.sgolovach.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TaskB {

    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        List<Double> array = new ArrayList<>();

        String line;

        while (!(line = scaner.nextLine()).equals("END")) {
            try {
                double a = Double.parseDouble(line);
                array.add(a);
                double sum = 0;
                for (Double aDouble : array) {
                    sum += aDouble;
                }
                double d = Math.sqrt(sum);
                if (a<0||sum<0) {
                    throw new ArithmeticException();
                }
                System.out.println(a + " " + d);
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String classN = element.getClassName();
                        int number = element.getLineNumber();
                        System.out.printf(" name:%s\n" + "class:%s\n" + " line:%d", name, classN, number);
                        break;
                    }
                }
            }
        }
    }
}
