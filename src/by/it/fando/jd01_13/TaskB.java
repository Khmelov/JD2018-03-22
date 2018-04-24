package by.it.fando.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        double n = 0;
        double sum = 0;
        double sqrt;

        while (!(str = scanner.next()).equals("END")) {
            try {
                n = Double.parseDouble(str);
                sum = sum + n;
                if (sum < 0)
                    throw new ArithmeticException();
                sqrt = Math.sqrt(sum);
                System.out.println(n + ", " + sqrt);
            }
            catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement [] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int number = element.getLineNumber();
                        System.out.printf(
                                "name:%s/n" +
                                        "class:%s/n" +
                                        "line:%d", name, className, number);
                        break;
                    }
                }
                System.out.println("==========");
            }
        }
    }







}
