package by.it.romankov.jd01_05;

import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        double sum = 0;
        double x;
        double a;
        for ( a = 0.0; a <= 2.0; a = a + 0.2 ) {
            sum = 0;
            for ( x = 1.0; x <= 6.0; x++ ) {
                sum = sum + (pow(7, a) - cos(x));
            }
            System.out.println("sum=" + sum);
        }

        double xx;
        double b = 0;
        double aa;

        for ( xx = -5.5; -6 < xx && xx < 2; xx = xx + 0.5 ) {
            if (xx / 2 > -2 && xx / 2 <= -1) {
                b = sin(pow(xx, 2));
            } else if (xx / 2 > -1 && xx / 2 < -0.2)
                b = cos(pow(xx, 2));
            else if (xx / 2 == 0.2)
                b = 1 / tan(pow(xx, 2));
            aa = log10(abs(b + 2.74));

            System.out.print(aa + " " + "при x=" + xx / 2);
            System.out.println();

        }


    }
}