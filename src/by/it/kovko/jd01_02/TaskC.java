package by.it.kovko.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] matrix;
        matrix=step1(n);
        int sum;
        sum=step2(matrix);
        System.out.println(sum);
        int[][] newMatrix;
        newMatrix=step3(matrix);
        for (int[] l : newMatrix) {
            for (int m : l) {
                System.out.print(m+" ");
            }
            System.out.println();
        }
    }
    private static int[][] step1(int n){
        Random r = new Random();
        boolean isMinusN=false, isPlusN=false;
        int matrix[][]=new int[n][n];
        while (!isMinusN || !isPlusN) {
            isPlusN=isMinusN=false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = r.nextInt(2 * n+1) - n;
                    if (matrix[i][j] == n)
                        isPlusN = true;
                    if (matrix[i][j] == -n)
                        isMinusN = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        return matrix;
    }


    private static int step2(int[][] mas){
        int sum=0;
        for (int[] ma : mas) {
            int positiveCount = 0;
            for (int aMa : ma) {
                if (aMa >= 0) {
                    ++positiveCount;
                    if (positiveCount > 1)
                        break;
                } else {
                    if (positiveCount == 1)
                        sum += aMa;
                }

            }
        }
        return sum;
    }
    private static int[][] step3(int[][] mas){
        int max=Integer.MIN_VALUE, maxColumns=0;
        for (int[] ma : mas) {
            for (int aMa : ma) {
                maxColumns = (maxColumns < ma.length) ? ma.length : maxColumns;
                max = (max < aMa) ? aMa : max;
            }
        }
        int[] rowsFlags = new int [mas.length];
        int[] columnsFlags = new int [maxColumns];

        for (int i = 0; i < mas.length; i++) {
            rowsFlags[i]=1;
        }
        for (int i = 0; i < maxColumns; i++) {
            columnsFlags[i]=1;
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j]==max){
                    rowsFlags[i]=0;
                    columnsFlags[j]=0;
                }
            }
        }


        int newRows=0;
        for (int x: rowsFlags)
            newRows+=x;
        int[][] newMatrix = new int[newRows][];
        int newRowsIndex=0;
        for (int i = 0; i < mas.length; i++) {
            int newColumns=0;
            if (rowsFlags[i]==1){
                int newColumnsIndex=0;
                for (int k = 0; k < mas[i].length; k++) {
                    newColumns+=columnsFlags[k];
                }
                newMatrix[newRowsIndex] = new int[newColumns];
                for (int j = 0; j < mas[i].length; j++) {
                    if (columnsFlags[j]==1){
                        newMatrix[newRowsIndex][newColumnsIndex]=mas[i][j];
                        ++newColumnsIndex;
                    }
                }
                ++newRowsIndex;
            }
        }
        for (int[] aNewMatrix : newMatrix) {
            for (int anANewMatrix : aNewMatrix) {
                System.out.print(anANewMatrix + " ");
            }
            System.out.println();
        }
        return newMatrix;
    }
}
