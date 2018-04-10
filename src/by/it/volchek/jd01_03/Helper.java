package by.it.volchek.jd01_03;

/**
 * Created by volchek on 27.03.18.
 */
public class Helper {
    static double findMax(double[] arr) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    static double findMin(double[] arr) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static void sort(double[] arr) {
        double a = 0;
        int b = 1;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - b; i++) {
                if (arr[i] > arr[i + 1]) {
                    a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = a;
                }

            }
            b++;
        }
        for (double z : arr) {
            System.out.print(" " + z);

        }
    }

    public static double[] mul(double[][] matrix, double[] vector) {
        if (matrix[0].length != vector.length)
            System.out.println("Количство строк матрицы не совпадает с размером вектора");
        double[] newVektor = new double[matrix.length];
        for (int i = 0; i < newVektor.length; i++) {
            double mult = 0;
            for (int j = 0; j < vector.length; j++) {
                mult = mult + matrix[i][j] * vector[j];
            }
            newVektor[i] = mult;
        }
        return newVektor;
    }

   public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        int size = matrixRight.length;
        double sum = 0;
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                for (int k = 0; k < size; k++) {
                    sum = sum + matrixLeft[i][k] * matrixRight[k][j];
                }
                resultMatrix[i][j] = sum;
                sum = 0;

            }

        }
        return resultMatrix;

    }
}
