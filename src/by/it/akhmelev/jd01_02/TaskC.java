package by.it.akhmelev.jd01_02;

import java.util.Arrays;
import java.util.Random;

public class TaskC {

    public static void main(String[] args) {
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        step3(m4);
    }

    static int[][] step1(int n) {
        Random random = new Random();
        boolean positive = false;
        boolean negative = false;

        int[][] res = new int[n][n];
        while (!(positive && negative))
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    int k = random.nextInt(2 * n + 1) - n;
                    if (k == -n) negative = true;
                    if (k == n) positive = true;
                    res[i][j] = k;
                }
            }
        for (int[] row : res) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        return res;
    }


    static int step2(int[][] mas) {
        int res = 0;
        for (int[] row : mas) {
            int i = 0;
            while (i < row.length && row[i] <= 0) i++;
            i++;
            while (i < row.length && row[i] <= 0) {
                res += row[i];
                i++;
            }
        }
        return res;
    }

    private static int[][] step3(int[][] mas) {
        if (mas.length == 0)
            return new int[0][0];
        int rows = mas.length;
        int cols = mas[0].length;
        boolean[] delRow = new boolean[rows];
        boolean[] delCol = new boolean[cols];
        int max = Integer.MIN_VALUE;
        for (int[] row : mas) {
            for (int element : row) {
                if (max < element) max = element;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    if (!delRow[i]) {
                        delRow[i] = true;
                        rows--;
                    }
                    if (!delCol[j]) {
                        delCol[j] = true;
                        cols--;
                    }
                }
            }
        }

        int[][] res = new int[rows][cols];
        int ii = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                int jj = 0;
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        res[ii][jj] = mas[i][j];
                        jj++;
                    }
                }
                ii++;
            }
        }
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
        return res;

    }
}
