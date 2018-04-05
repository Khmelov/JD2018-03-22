package by.it.poprugo.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);
    }

    static int[][] step1(int n) {
        Random random = new Random();
        ///int teat = random.nextInt(2 * n);
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
            System.out.println(Arrays.toString(row));
        }
        return res;
//        int a = 0 - n; // начальное значение диапазона - "от"
//        int b = 2 * n + 1; // конечное значение диапазона - "до"
//        int mas1[][] = new int[n][n];
//        int num;
//        int k = 0;
//        boolean check1 = true, check2 = true;
//        while (check1 | check2) {
//            check1 = true;
//            check2 = true;
//            for (int i = 0; i < mas1.length; i++) {
//                for (int j = 0; j < mas1[i].length; j++) {
//                    num = a + (int) (Math.random() * b); // Генерация 1-го числа
//                    //System.out.println(++k + "-ое случайное число: " + num);
//                    mas1[i][j] = num;
//                    if (num == -n) check1 = false;
//                    if (num == n) check2 = false;
//                }
//            }
        //System.out.print(++k+", ");
//    }
//        System.out.println();
//
//        for(
//    int[] masRow :mas1)
//
//    {
//        for (int j = 0; j < masRow.length; j++) {
//            System.out.print(masRow[j] + " ");
//        }
//        System.out.println();
//    }
//}
    }

    static int step2(int[][] mas) {
        int res = 0;
        boolean start, stop;
        for (int[] row : mas) {
            int i = 0;
            while (i < row.length && row[i] <= 0) i++; //находит 1е положительное число
            i++;       // начиная со следующего элемента матрицы суммируем, пока не дойдём до след положительного
            while (i < row.length && row[i] <= 0) { //находит 2е положительное число, после чего прекращает суммирование
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
        // missed
        }
        for (int j = 0; j < mas.length; j++) {
        // missed
            if (!delCol[j]) {
                delCol[j] = true;
                cols--;
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
            System.out.println(Arrays.toString(res));
        }
        return res;
    }

}