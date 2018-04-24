package by.it.romankov.jd01_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        List <String> list = new ArrayList <>();
        while (true) {
            String s = scanner.next();
            if (s.equals("END"))
                break;
            else {
                list.add(s);
                try {
                    double d = Double.parseDouble(s);
                    sum = sum + d;
                    LinkedList <Double> doubls = new LinkedList <>();
                    doubls.add(d);
                    System.out.println(doubls.getLast());
                } catch (NumberFormatException e) {
                    System.out.println("NumberFormatException");
                }

                try {
                    System.out.println(Math.sqrt(sum));
                } catch (ArithmeticException e) {
                    System.out.println("ArithmeticException");
                }

            }
        }

    }
}
