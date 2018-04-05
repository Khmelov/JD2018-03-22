package by.it.sgolovach.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            System.out.print("При a=" + a + " Сумма у = ");
            for (int x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.print(y + "\n");
        }
    }

    private static void step2() {
        for (double x = -5.5; x < 2; x = x + 0.5) {
            double a = x / 2;
            System.out.print("При x/2=" + a);
            double y = 0;
            if (a > -2.0 && a < 0.25) {
                if (a > -2.0 && a <= -1.0) System.out.print(" a = " + (y = log10(abs(sin(x * x) + 2.74))));
                if (a > -1.0 && a < 0.2) System.out.print(" a = " + (y = log10(abs(cos(x * x) + 2.74))));
                if (a == 0.2) System.out.print(" a = " + (y = log10(abs(atan(x * x) + 2.74))));
            } else System.out.print(" вычисления не определены");
            System.out.println();
        }

    }
}
