package by.it.verishko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            double y1 = pow(7, a);
            for (int x = 1; x <= 6; x++) {
                double y2 = cos(x);
                y = y + (y1 - y2);
            }
            System.out.printf("При a=%-5.2f y=%-5.10f\n", a, y);
        }
        System.out.println();
    }

    private static void step2() {
        double a;
        double b;
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
            } else if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
            } else {
                System.out.printf("При x/2=%-5.2f вычисления не определены\n", x / 2);
                continue;
            }
            a = log10(abs(b + 2.74));
            System.out.printf("При x/2=%-5.2f a=%-8.10f\n", x / 2, a);
        }
    }
}
