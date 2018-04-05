package by.it.shekh.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();

    }

    private static void step4() {
        double x, y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }

            System.out.printf("For a=%-6.1f y=%8.8f\n", a, y);
            y = 0;
        }
    }

    private static void step5() {
        double alpha, beta;
        for (double x = -5.5; x < 2; x += 0.5) {
            if ((x / 2 > -2) && (x / 2 <= -1)) {
                beta = sin(pow(x, 2));
            } else if ((x / 2 > -1) && (x / 2 < 0.2))
                beta = cos(pow(x, 2));
            else if (x / 2 == 0.2)
                beta = 1.0 / (tan(pow(x, 2)));
            else {
                System.out.printf("При x/2=%2.1f alpha не определены\n", x / 2);
                continue;
            }
            alpha=log10(abs(beta+2.74));
            System.out.printf("При x/2=%2.1f alpha=%6.6f\n",x/2,alpha);


        }
    }
}
