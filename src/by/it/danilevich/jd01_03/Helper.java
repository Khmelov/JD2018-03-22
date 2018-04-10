package by.it.danilevich.jd01_03;

import java.util.Scanner;

public class Helper {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        double[] arr= InOut.getArray(s);
        findMin(arr);
        findMax(arr);
        sort(arr);
    }

    static double findMin(double[ ] arr){
       double min = Double.MAX_VALUE;
        for (double elem: arr) {
            if (elem < min) min = elem;
        }
        return min;
    }
    static double findMax(double[ ] arr){
           double max = Double.MIN_VALUE;
        for (double elem: arr) {
            if (elem > max) max = elem;

        }
        return max;
    }
    static double[] sort(double[ ] arr){
    //по возрастанию
        int dlina = arr.length;
        while (dlina > 0) {
            for (int i = 0; i < (dlina-1); i++) {
                if (arr[i] > arr[i+1]) {
                    double vrem = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = vrem;
                }
              }
            dlina = dlina - 1;
        }
        InOut.printArray(arr);
        return arr;
    }



    static double mulToSum(double[] matr1, double[] matr2){
        double sum =0;
        for (int i = 0; i < matr1.length; i++) {
            sum = sum + matr1[i]*matr2[i];
        }
        return sum;
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] newMas = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            double[] vrem = matrix[i];
            newMas[i] = mulToSum(vrem,vector);
        }
        return newMas;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        //умножаем строку на столбец
        double[][] newMas = new double[matrixLeft.length][matrixRight[0].length];
        for (int i= 0; i < matrixLeft.length; i++) {
            double[] matr1 = matrixLeft[i];
            for (int j = 0; j < matrixRight[0].length; j++) {
                //получим матрицу из элементов столбца
                double[] matr2 = new double[matrixRight.length];
                for (int k = 0; k < matrixRight.length; k++) {
                    matr2[k] = matrixRight[k][j];
                }
                 double sum = mulToSum(matr1, matr2);
                newMas[i][j] = sum;


            }

        }

        return newMas;
    }

}
