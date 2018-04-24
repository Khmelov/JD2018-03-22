package by.it.lyukovich.jd_01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        double num, sum = 0, sqrt;
        while (!(str = sc.nextLine()).equalsIgnoreCase("end"))
            try {
                num = Double.parseDouble(str);
                sum += num;
                sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt))
                    throw new ArithmeticException();
                System.out.println(num + " " + sqrt);
            } catch (Exception e) {
                System.out.println("name: " + e.getClass().getName());
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.println("class: " + element.getClassName() + "\n" + "line: " + element.getLineNumber());
                        break;
                    }
                }
        }
    }
}
