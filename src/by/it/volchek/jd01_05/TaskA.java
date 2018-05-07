package by.it.volchek.jd01_05;

import static java.lang.Math.*;

/**
 * Created by volchek on 31.03.18.
 */
public class TaskA {
    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow((x * x + PI / 6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println("z=" + z);

    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.println("y=" + y);
    }

    private static void step3() {
        double x = 12.1;
        double dA = 3.75;
        double f = 0;
        for (double i = -5; i <= 12; i += dA) {
            f = pow(E, i * x) - 3.45 * i;
            System.out.println("Для a = " + i + " значение функции равно " + f);

        }
    }

    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }


}
