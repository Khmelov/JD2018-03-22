package by.it.verishko.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static void sort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] > arr[j]) || (!(arr[i] < arr[j]))) {
                    double m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] r = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    r[i][j] = r[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        return r;
    }
}


