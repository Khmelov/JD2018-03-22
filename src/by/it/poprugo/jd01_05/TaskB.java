package by.it.poprugo.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        double a = 0.0;
        double aMax = 2.0;
        double delta = 0.2;
        double y;
        while (a <= aMax) {
            double sum = 0;
            for (int x = 1; x <= 6; x++) sum += cos(x);
            y = pow(7, a) - sum;
            System.out.printf("При a=%.2f Сумма y = ", a);
            System.out.println(y);
            a += delta;
        }
    }

    private static void step5() {
        double delta = 0.5;
        double alfa = 0;
        double betta;
        for (double x = -6.0; x < 2.0; x += delta) {
            double x2 = x / 2;
            System.out.printf("При x/2=%.2f ", x2);
            if ((x2 > (-2.0)) && (x2 <= (-1.0))) {
                betta = sin((pow(x, 2)));
                alfa = log10(abs(betta + 2.74));
                System.out.println(" a = " + alfa);
            } else if ((x2 > (-1.0)) && (x2 < (0.2))) {
                betta = cos((pow(x, 2)));
                alfa = log10(abs(betta + 2.74));
                System.out.println(" a = " + alfa);
            } else if (x2 == 0.2) {
                betta = 1 / tan(pow(x, 2)); //ctang
                alfa = log10(abs(betta + 2.74));
                System.out.println(" a = " + alfa);
            } else {
                System.out.println("вычисления не определены");
            }
        }
    }
}