package by.it.poprugo.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        double err0 = 0.0;
        if (arr.length == 0) {
            System.out.println("ошибка: пустой массив ");
            return err0;
        } else {
            double min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (min > arr[i]) min = arr[i];
            }
            return min;
        }
    }

    static double findMax(double[] arr) {
        double err0 = 0.0;
        if (arr.length == 0) {
            //System.out.println("ошибка: пустой массив ");
            return err0;
        } else {
            double max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i]) max = arr[i];
            }
            return max;
        }
    }

    static void sort(double[] arr) {
        boolean check;
        int last = arr.length - 1;
        double aBuff;
        do {
            check = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    aBuff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aBuff;
                    check = true;
                }
            }
        }
        while (check);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] multy = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                multy[i] = multy[i] + matrix[i][j] * vector[j];
        return multy;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] multi = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++) {
                    multi[i][j] = multi[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
        }
        return multi;
    }
}
