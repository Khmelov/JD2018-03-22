package by.it.volchek.jd01_02;

import java.util.Scanner;

/**
 * Created by volchek on 25.03.18.
 */
public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);
        System.out.println(step2(mas));
        //int[][] mas1 = step3(mas);


    }

    private static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int elem[] : mas) {
            for (int subElem : elem) {
                if (subElem > max) max = subElem;
            }
        }

        int flagH = 0;
        int flagV = 0;
        int rows = 0;
        int columns = 0;


        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == max)
                    flagH++;
            }


            if (flagH > 0) flagH = 0;
            else {
                rows++;
                flagH = 0;
            }
        }

        flagH = 0;
        int flagMH = 0;
        int[][] masH = new int[rows][mas[0].length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if ((i - flagMH) >= rows) break;
                masH[i - flagMH][j] = mas[i][j];
                if (mas[i][j] == max)
                    flagH++;
            }
            if (flagH == 0) flagH = 0;
            else {
                flagMH++;
                flagH = 0;
            }
        }


        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[j][i] == max)
                    flagV++;

            }

            if (flagV > 0) flagV = 0;
            else {
                columns++;
                flagV = 0;
            }
        }

        flagV = 0;
        int flagMV = 0;
        int[][] masV = new int[rows][columns];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[j][i] == max)
                    flagV++;
            }
            if (flagV == 0) {
                flagV = 0;
                for (int j = 0; j < rows; j++) {
                    if ((i - flagMV) >= columns) break;
                    masV[j][i - flagMV] = masH[j][i];
                }
            } else {
                flagV = 0;
                for (int j = 0; j < rows; j++) {
                    if ((i - flagMV) >= columns) break;
                    masV[j][i - flagMV] = masH[j][i];
                }
                flagMV++;
            }


        }


        for (int[] a : masV) {
            for (int b : a) {
                System.out.print(b + " ");

            }
            System.out.println();
        }


        return masV;


    }

    private static int step2(int[][] mas) {
        int flag;
        int count = 0;
        int subCount;
        for (int[] element : mas) {
            flag = 0;
            subCount = 0;
            for (int subElement : element) {
                if (subElement > 0) flag++;
                if ((flag == 1) & (subElement <= 0)) subCount = subCount + subElement;

            }
            if (flag == 1) subCount = 0;
            count = count + subCount;
        }
        return count;
    }

    private static int[][] step1(int i) {
        int[][] mas = new int[i][i];
        int flag1, flag2;
        do {
            flag1 = 0;
            flag2 = 0;
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i; k++) {
                    mas[j][k] = (int) (-i - 1 + Math.random() * (i + 1) * 2);
                    if (mas[j][k] == i) flag1++;
                    if (mas[j][k] == -i) flag2++;
                }
            }
        } while (!(flag2 != 0 & flag1 != 0));

        for (int element[] : mas) {
            for (int subElement : element) {
                System.out.print(subElement + " ");
            }
            System.out.println();

        }

        return mas;
    }

}
