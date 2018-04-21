package by.it.uskoryaev.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        List<Double> listNumb = new ArrayList<>();
        double numCor=0;
        try {
            while (!(str = scanner.next()).equals("end")) {
                double numb = Double.parseDouble(str);
                System.out.println(numb);
                listNumb.add(numb);
                numCor+=numb;
                System.out.println(Math.sqrt(numCor));
            }

        }catch (ArithmeticException | NumberFormatException e){
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                    System.out.println("name: "+e.getClass().getName());
                    System.out.println("class: "+stackTraceElement.getClassName());
                    System.out.println("line: "+stackTraceElement.getLineNumber());
                    break;
                }
            }
        }
    }
}
