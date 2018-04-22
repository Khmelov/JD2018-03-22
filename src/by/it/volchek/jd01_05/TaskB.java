package by.it.volchek.jd01_05;

import static java.lang.Math.*;

/**
 * Created by volchek on 31.03.18.
 */
public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double i = 0; i <= 2; i += 0.2) {
            for (int j = 1; j <= 6; j++) {
                y += pow(7, i) - cos(j);
            }

            System.out.printf("Для значения a = %-6.2f значение y = %8.8f\n", i, y);
            y = 0;

        }
    }

    private static void step2() {
        double alfa;
        double beta;
        for (double i = -5.5; i < 2; i += 0.5) {
            if ((-2 < i / 2) && (i / 2 <= -1)) {
                beta = sin(i * i);
            } else if ((-1 < i / 2) && (i / 2 < 0.2)) beta = cos(i * i);
            else if (i / 2 == 0.2) beta = 1 / tan(i * i);
            else {
                System.out.printf("При x/2=%2.2f значения не определены\n", i / 2);
                continue;
            }
            alfa = log10(abs(beta + 2.74));
            System.out.printf("При x/2=%2.2f a = %8.8f\n", i / 2, alfa);


        }


    }


}
