package by.it.kirova.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        double num = 0, sum = 0, sqrt;
        while (!(str = scanner.nextLine()).equals("END"))
            try {
                num = Double.parseDouble(str);
                sum += num;
                sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt))
                    throw new ArithmeticException();
                System.out.println(num + " " + sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                printExeption(e);
            }

    }


    private static void printExeption(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (TaskB.class.getName().equals(element.getClassName())) {
                String name = e.getClass().getName();
                String className = element.getClassName();
                int number = element.getLineNumber();
                System.out.printf(
                    "  name:%s\n" +
                    " class:%s\n" +
                    "  line:%d", name, className, number);
                System.out.println();
                break;
            }
        }
    }


}

