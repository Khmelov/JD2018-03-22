package by.it.shekh.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step6();
    }

    private static void step6() {
        int nelem = 0;
        for (double i = 5.33; i <= 9; i += 0.094) {
            nelem++;
        }
        int num = 0, newmasnum = 0;
        double avgeom = 1;

        System.out.println("Total elements in array w'd be: " + nelem);
        double mas[] = new double[nelem];
        for (double x = 5.33; x <= 9; x += 0.094) {
            mas[num] = pow(x * x + 4.5, 1.0 / 3);
            System.out.printf("V[%2d]=%6.6f ", num, mas[num]);
            if (mas[num] > 3.5) {
                avgeom *= mas[num];
                newmasnum++;

            }

            num++;
            if (num % 4 == 0) {
                System.out.println("");
                System.out.println("-----------------------------------------------------------");
            }

        }
        int k = 0;
        double[] newmas = new double[newmasnum];
        for (int i = num - newmasnum; i < num; i++) {
            newmas[k] = mas[i];
            System.out.printf("NewV[%2d]=%6.6f ", k, newmas[k]);
            k++;
            if (k % 3 == 0) System.out.println();
        }
        System.out.println("------------------------------------------------------------");
        avgeom = pow(avgeom, 1.0 / newmasnum);
        System.out.println(avgeom);


    }

}
