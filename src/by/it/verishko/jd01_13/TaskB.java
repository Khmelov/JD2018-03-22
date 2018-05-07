package by.it.verishko.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        double strings, sum = 0, sqrt;
        while (!(str = sc.nextLine()).equals("END"))
            try {
                strings = Double.parseDouble(str);
                sum = sum + strings;
                sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt))
                    throw new ArithmeticException();
                System.out.println(strings + " " + sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int number1 = element.getLineNumber();
                        System.out.printf("name: %s \n" + "line: %d \n" + "class: %s\n", name, number1, className);
                        break;
                    }
                }
            }
    }
}
