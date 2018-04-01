package by.it.kirova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
    step1();
        System.out.println();
    step2();
    }


    private static void step1() {
          for (double a=0; a<=2; a= a + 0.2) {
              double y = 0;
              double y1 = pow(7, a);
              for (int x = 1; x <=6 ; x++) {
                double y2 = cos(x);
                y = y + (y1 - y2);
            }
              System.out.print("При a=");
              System.out.printf("%-5.2f", a);
              System.out.print(" Сумма y = ");
              System.out.printf("%-5.10f\n", y);

        }

    }

    private static void step2() {

        for (double x = -5.5; x < 2; x = x + 0.5) {
            double b;
            if (x/2 > -2 && x/2 <= -1) {
                b = sin(pow(x,2));
            }
            else if (x/2 > -1 && x/2 < 0.2) {
                b = cos(pow(x,2));
            }
            else if (x/2 == 0.2) {
                b = 1/tan(pow(x,2));
            }
            else {
                System.out.print("При x/2=");
                System.out.printf("%-5.2f", x/2);
                System.out.println(" вычисления не определены");
                continue;
            }
            double a = log10(abs(b + 2.74));
            System.out.print("При x/2=");
            System.out.printf("%-7.2f", x/2);
            System.out.print(" а = ");
            System.out.printf("%-7.10f\n", a);
        }
    }

}