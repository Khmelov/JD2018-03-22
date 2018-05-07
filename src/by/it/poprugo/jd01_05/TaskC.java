package by.it.poprugo.jd01_05;

import java.awt.*;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int dim = (int) ceil((9 - 5.33) / 0.107);
        double[] z = new double[dim];
        int i = 0;
        for (double x = 5.33; x <= 9; x += 0.107) {
            z[i] = pow((pow(x, 2) + 4.5), 1.0 / 3);
            i++;
        }
        System.out.println("Array A[]");
        for (int k = 0; k < dim; k++) {
            if (floorMod((k + 1), 5) != 0) {
                System.out.printf(" A[%2d] = %f ", k, z[k]);
            } else {
                System.out.printf(" A[%2d] = %f \n", k, z[k]);
            }
        }
        int dimB = 0;
        for (int j = 0; j < dim; j++) {
            if (z[j] > 3.5) dimB++;
        }
        double[] b = new double[dimB];
        int jB = 0;
        for (int j = 0; j < dim; j++) {
            if (z[j] > 3.5) {
                b[jB] = z[j];
                jB++;
            }
        }
        System.out.println("Array B[] from elements of Array A[] > 3.5");
        for (int k = 0; k < dimB; k++) {
            if (floorMod((k + 1), 5) != 0) {
                System.out.printf(" B[%2d] = %f ", k, b[k]);
            } else {
                System.out.printf(" B[%2d] = %f \n", k, b[k]);
            }
        }
        /*nothing*/
        char[] pGr = {'\u2554', /*uvl */ '\u2550', /*lin*/
                '\u2566', /*tv*/ '\u2557', /* upv*/
                '\u256C', /* kryj */ '\u255A', // uln
                '\u2569', /*tn*/'\u255D', // upn
                '\u2551' /*'\u2551'*/, '\u2502'}; /*'\u2502'*/
        /*for (int ii = 0; ii < pGr.length; ii++) {
            System.out.print(pGr[ii]);
            if (ii == 3 || ii == 4 || ii == 7)
                System.out.println();
        }*/

        System.out.println();
        System.out.print('\u250C');
        for (int j = 0; j < 76; j++) {
            System.out.print('\u2500');
            if (j == 75) System.out.println();
        }
        System.out.println('\u2502' + "Massiv A");
        System.out.print('\u2502');
        for (int j = 1; j < 71; j++) {
            if (j == 1) System.out.print(pGr[0]);
            else if (j == 15 || j == 29 || j == 43 || j == 57)
                System.out.print(pGr[2]);
            System.out.print(pGr[1]);
        }
        System.out.println(pGr[3]);
        System.out.printf("%s", pGr[9]);
        for (int k = 1; k < dim + 1; k++) {
            System.out.print(pGr[8]);
            if (floorMod(k, 5) != 0) {
                System.out.printf(" A[%2d] = %3.2f ", k, z[k - 1]);
            } else {
                System.out.printf(" A[%2d] = %3.2f ", k, z[k - 1]);
                System.out.println(pGr[8]);
                System.out.print(pGr[9]);
                for (int j = 1; j < 71; j++) {
                    if (j == 1) {
                        if (k == dim) System.out.print(pGr[5]);
                        else System.out.print('\u2560');
                    } else if (j == 15 || j == 29 || j == 43 || j == 57)
                        if (k == dim) System.out.print(pGr[6]);
                    else System.out.print(pGr[4]);
                    System.out.print(pGr[1]);
                }
                if (k == dim) System.out.println(pGr[7]);
                else {
                    System.out.println('\u2563');
                    System.out.print(pGr[9]);
                }
            }
        }
    }
}
