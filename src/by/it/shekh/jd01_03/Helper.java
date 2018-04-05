package by.it.shekh.jd01_03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double el : arr) {
            if (el < min) min = el;
        }
        return min;
    }


    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double el : arr) {
            if (el > max) max = el;
        }
        return max;
    }


    static void sort(double[] arr) {
        Arrays.sort(arr);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double [] res=new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <vector.length ; j++) {
                res[i]+=matrix[i][j]*vector[j];
            }
        }
        return res;
    }


    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++) {
            for (int j = 0; j <matrixRight[0].length ; j++) {
                for (int k = 0; k <matrixRight.length ; k++) {
                    res[i][j]+=matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return res;
    }
}