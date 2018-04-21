package by.it.volchek.jd01_13;

import java.util.Scanner;

/**
 * Created by volchek on 19.04.18.
 */
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double number = 0.0, sumNumber = 0.0, sqrtNumber = 0.0;
        String str;

        for (; ; ) {
            str = scanner.nextLine();
            try {
                if (str.equals("END")) break;
                number = Double.parseDouble(str);
                if (number<0) throw new ArithmeticException();
                sumNumber += number;
                sqrtNumber = Math.sqrt(sumNumber);
                System.out.println(number + " " + sqrtNumber);
            } catch (NumberFormatException|ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int number1 = element.getLineNumber();
                        System.out.printf("name: %s \n" +"line: %d \n"+"class: %s\n", name, number1,className);
                        break;
                    }

                }

            }
        }
    }
}
