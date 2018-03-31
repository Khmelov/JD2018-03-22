package by.it.kirova.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность матрицы:");
        int n = scanner.nextInt();
        System.out.println("Полученная с помощью рандома матрица в интервале значений [-" + n + "; " + n + "]:");

        int mas[][] = step1(n);
        step2(mas);
        int[][] result = step3(mas);
        printMas(result);

    }


    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        do {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                }
            }
        }
        while (!stepCheck(mas, n) || !stepCheck(mas, -n));
        printMas(mas);

        return mas;
    }

    private static boolean stepCheck(int[][] mas, int n) {
        for (int[] row : mas) {
            for (int element : row)
                if (element == n)
                    return true;
        }
        return false;

    }


    private static void printMas(int[][] mas) {
        for (int[] row : mas) {
            for (int element : row) {
                System.out.format("%5d", element);
            }
            System.out.println();
        }
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int s = getFirstPositive(mas[i], 0);
            if (s == -1)
                continue;
            int f = getFirstPositive(mas[i], s + 1);
            if (f == -1)
                continue;
            for (int j = s + 1; j < f; j++) {
                sum = sum + mas[i][j];
            }
            //System.out.println(s + " " + f + " " + sum);
        }
        System.out.println("Сумма равна:");
        System.out.println(sum);
        return sum;
    }

    private static int getFirstPositive(int[] row, int start) {
        for (int i = start; i < row.length; i++) {
            if (row[i] > 0)
                return i;
        }
        return -1;
    }



    private static int getMax(int[][] mas1) {
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas1[i].length; j++) {
                if (mas1[i][j] > m) {
                    m = mas1[i][j];
                }
            }
        }
        return m;
    }


    private static int[][] step3(int[][] mas) {
        // Более универсальный способ проверка максимума getMax, останется рабочим даже при изменениии задания
        // Согласно текущему условию можно было получить так:  int max = mas.length;
        // В тесте max значение в масииве 4х4 равно 6, что прротиворечит Step1.
        int max = getMax(mas);
        int n = mas.length;
        boolean[] rowMask = new boolean[n];
        boolean[] colMask = new boolean[n];
        initMasks(mas, rowMask, colMask, max);
        int rowCount = getFalseCount(rowMask);
        int colCount = getFalseCount(colMask);
        int[][] masres = new int[rowCount][colCount];
        int ri = -1;
        for (int i = 0; i < mas.length; i++) {
            if (rowMask[i])
                continue;
            ri++;
            int rj = -1;
            for (int j = 0; j < mas[i].length; j++) {
                if (colMask[j])
                    continue;
                rj++;
                masres[ri][rj] = mas[i][j];
            }
        }
        return masres;
    }

    private static void initMasks(int[][] mas, boolean[] rowMask, boolean[] colMask, int r) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == r) {
                    rowMask[i] = true;
                    colMask[j] = true;
                }
            }
        }
    }


    private static int getFalseCount(boolean[] mas) {
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!mas[i])
                count++;
        }
        return count;
    }


}



    /*
    private static int[] getPosition(int[][] mas, int max) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
*/












