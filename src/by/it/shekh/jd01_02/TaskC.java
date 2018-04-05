package by.it.shekh.jd01_02;

import java.util.*;

public class TaskC {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int mas2[][] = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        int mas[][] = step1(n);
        step2(mas);
        step3(mas);
    }


    private static int[][] step1(int n) {
        Random rnd = new Random(System.currentTimeMillis());
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (-n) + rnd.nextInt(n - (-n) + 1);
            }
        }
        boolean hasn = false, hasmn = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mas[i][j] == n) hasn = true;
                else if (mas[i][j] == (-n)) hasmn = true;
            }
        }

        if (hasn && hasmn) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%4d", mas[i][j]);
                }
                System.out.println();
            }


        } else {
            mas = step1(n);
        }
        return mas;

    }

    private static int step2(int[][] mas) {

        int s = 0;
        for (int i = 0; i < mas.length; i++) {
            int fipos = 0, sepos = 0;
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] > 0) {
                    fipos = j;
                    break;
                }
            }
            for (int j = fipos + 1; j < mas[0].length; j++) {
                if (mas[i][j] > 0) {
                    sepos = j;
                    break;
                }
            }
            for (int j = fipos + 1; j < sepos; j++) s += mas[i][j];

        }
        System.out.println(s);
        return s;
    }

    private static int[][] step3(int mas[][]) {
        int max = Integer.MIN_VALUE;
        int s = 0;
        int[] imax = new int[mas.length * mas.length], jmax = new int[mas.length * mas.length];
        //int imax=-1, jmax=-1;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] > max) max = mas[i][j];

            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == max) {
                    imax[i] = 1;
                    jmax[j] = 1;
                    s++;
                }
            }
        }
        int minusi = 0, minusj = 0;
        for (int i = 0; i < mas.length; i++) {
            if (imax[i] == 1) minusi++;
            if (jmax[i] == 1) minusj++;
        }
        System.out.println("Minus i and j" + minusi + " " + minusj);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.println("imax: " + i + "=" + imax[i] + " jmax: " + j + "=" + jmax[j]);
            }
            System.out.println();
        }
        int l = 0, t;
        int[][] mas1 = new int[mas.length-minusi ][mas[0].length-minusj];
        for (int i = 0; i < mas.length; i++) {
            t = 0;
            if (imax[i] == 1) continue;
            for (int j = 0; j < mas[0].length; j++) {
                if (jmax[j] == 1) continue;

                System.out.println("Новая i:"+l+" Старая i:"+i+" Новая j:"+t+" Старая j:"+j);
                mas1[l][t] = mas[i][j];
                t++;
            }
            l++;
        }

        System.out.println("Num of max: " + s);
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas1[0].length; j++) {
                System.out.print(mas1[i][j] + " ");
            }
            System.out.println();
        }
        return mas1;
    }
}