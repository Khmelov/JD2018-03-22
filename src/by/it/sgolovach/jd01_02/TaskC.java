package by.it.sgolovach.jd01_02;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        int n = scaner.nextInt();
        int[][] mas = new int[n][n];
        System.arraycopy(step1(n), 0, mas, 0, n);
        step2(mas);
        step3(mas);


    }

    private static int[][] step1(int n) {

        boolean positive = false;
        boolean negative = false;
        int[][] mas1 = new int[n][n];
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int a = (int) (Math.random() * (n * 2 + 1)) - n;
                    if (a == -n) negative = true;
                    if (a == n) positive = true;
                    mas1[i][j] = a;
                }
            }
        } while (!positive && !negative);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas1[i][j] + " ");
            }
            System.out.println();

        }
        return mas1;
    }

    private static int step2(int[][] mas) {
        int a = 0;
        int lim = 0;
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {

                if (mas[i][j] >= 0 && j != mas.length) {
                    lim++;
                    for (int k = j + 1; k < mas.length; k++) {
                        if (mas[i][k] >= 0 && k == (mas.length - 1)) lim++;
                        if (mas[i][k] < 0 && lim != 2 && k != (mas.length - 1)) sum = sum + mas[i][k];
                        else break;
                    }
                }
            }
            lim = 0;
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                for (int[] element : mas) {
                    if (element[j] != max) {
                        if (max < element[j]) max = element[j];
                    }
                }
            }
        }

        boolean[] col = new boolean[mas.length];
        boolean[] str = new boolean[mas.length];
        int col1 = 0, str1 = 0;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) col[i] = true;
                if (mas[j][i] == max) str[i] = true;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            if (col[i] == false) col1++;
        }

        for (int i = 0; i < mas.length; i++) {
            if (str[i] == false) str1++;
        }

        int[][] res = new int[col1][str1];
        int c = 0;

        for (int i = 0; i < mas.length; i++) {
            int s = 0;
            if (col[i] == false) {
                for (int j = 0; j < mas.length; j++) {
                    if (str[j] == false) {
                        res[c][s] = mas[i][j];
                        s++;
                    }
                }
                c++;
            }
        }

        for (int i = 0; i < col1; i++) {
            for (int j = 0; j < str1; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

        return res;
    }
}
