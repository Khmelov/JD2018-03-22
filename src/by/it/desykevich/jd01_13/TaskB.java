package by.it.desykevich.jd01_13;

import java.util.Scanner;

public class TaskB {
    private static double sumOfSquares = 0;
    private static double sumOfElements = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("END")){
            try {
                double element = Double.parseDouble(line);
                if (element < 0) throw new ArithmeticException();
                sumOfSquares = sumOfSquares + Math.sqrt(element);
                sumOfElements = sumOfElements + element;
                System.out.println(element + " " + sumOfSquares + Math.sqrt(sumOfElements));
            } catch (NumberFormatException | ArithmeticException exception){
                String nameOfException = exception.getClass().getName();
                System.out.printf("name: %s\n", nameOfException);
                String nameOfCurrentClass = TaskB.class.getName();
                StackTraceElement[] trace = exception.getStackTrace();
                for (StackTraceElement one : trace) {
                    if (one.getClassName().equals(nameOfCurrentClass)) {
                        System.out.println("class: " + nameOfCurrentClass);
                        System.out.println("line: " + one.getLineNumber());
                    }
                }
            }
        }
    }
}
