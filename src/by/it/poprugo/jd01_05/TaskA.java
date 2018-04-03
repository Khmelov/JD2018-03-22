package by.it.poprugo.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z = Math.cos(pow((pow(x, 2) + PI / 6), 5)) - sqrt((x * pow(a, 3)))
                - log(abs((a - 1.12 * x) / 4));
        System.out.println("Z = " + z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow((a + b), 2)) - pow((a + 1.5), 1.0 / 3) + a * pow(b, 5)
                - b / (log((pow(a, 2))));
        System.out.println("y = " + y);
    }

    private static void step3() {
        double x = 12.1;
        double a = -5.0;
        double aMax = 12.0;
        double delta = 3.75;
        double f;
        while (a < aMax) {
            f = exp((a * x)) - 3.45 * a;
            System.out.printf("При a= %4.2f f= ",a);
            System.out.println(f);
            a += delta;
        }
    }


}
