package by.it.uskoryaev.jd01_05;
import java.util.Date;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0.0; a <= 2.0; a = a + 0.2) {
            double sigmaSum = 0;
            double resultSt = pow(7,a);
            for (int x = 1; x <= 6; x++){
                sigmaSum = sigmaSum+resultSt-cos(x);
            }
            System.out.println("y="+sigmaSum);
        }
    }

    private static void step2() {
        double b;
        for (double x = -6.0; x < 2.0; x = x + 0.5) {
            if (-2 < x / 2 && x / 2 <= -1) b = sin(x * x);
                else if (-1 < x / 2 && x / 2 < 0.2) b = cos(x * x);
                    else if (x / 2 == 0.2) b = 1.0 / tan(x * x);
                        else {
                            System.out.printf("При x/2=%2.2f значения не определены",x/2);
                            System.out.println();
                        continue;
                            }
            double a = log10(abs(b + 2.74));
            System.out.printf("При x/2=%2.2f",x/2);
            System.out.println(" a="+a);
        }
    }
}
