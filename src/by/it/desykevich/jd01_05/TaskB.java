package by.it.desykevich.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class TaskB {

    public static void main(String[] args) {

        step1();
        step2();

    }

    private static void step1() {
        double y=0;
        for (double a = 0; 0 <= a && a <= 2; a = a + 0.2) {
            for (double x = 1; 1 <= x && x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.println("a= " + a + " y=" + y);
        }
        System.out.println();

    }
    private static void step2() {
        for (double x = -5.5; -6 < x && x < 2; x = x + 0.5) {
            double a;
            if (-2 < (x / 2) && (x / 2) <= -1) {
                a = log10((sin(pow(x, 2)) + 2.74));
                System.out.println("При x/2=" + x / 2 + " a=" + a);
            } else if (-1 < (x / 2) && (x / 2) < 0.2) {
                a = log10(cos(pow(x, 2)) + 2.74);
                System.out.println("При x/2=" + x / 2 + " a=" + a);
            } else if ((x / 2) == 0.2) {
                a = log10(1 / (tan(pow(x, 2))) + 2.74);
                System.out.println("При x/2=" + x / 2 + " a=" + a);
            } else
                System.out.println("При x/2=" + x / 2 + " вычисления не определены");
        }
        System.out.println();


    }
}
