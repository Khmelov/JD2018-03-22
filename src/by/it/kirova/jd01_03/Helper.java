package by.it.kirova.jd01_03;


//import java.util.Arrays;

public class Helper {


    /**
     * Нахождение минимального значения в одномерном массиве
     * @param arr - одномерный массив типа double
     * @return n - значение минимального элемента одномерного массива
     */
    static double findMin(double[] arr) {
        double n = Double.MAX_VALUE;
        for (double element : arr) {
            if (element < n) {
                n = element;
            }
        }
        return n;
    }

    /**
     * Нахождение максимального значения в одномерном массиве
     * @param arr - одномерный массив типа double
     * @return m - значение максимального элемента одномерного массива
     */
    static double findMax(double[] arr) {
        double m = Double.MIN_VALUE;
        for (double element : arr) {
            if (element > m) {
                m = element;
            }
        }
        return m;

    }

    /**
     * Сортировка значений в одномерном массиве в порядке возврастания
     * @param arr - одномерный массив типа double
     */
    static void sort(double[] arr) {
        //Arrays.sort(arr);
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = last; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        double tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        swap = true;
                    }
                }

            }
            last--;
        }
        while (swap);
        InOut.printArray(arr);
    }

    /**
     * Умножение матрицы размера M x N на вектор размера M
     * @param matrix - двумерный массив типа double (матрица)
     * @param vector - одномерный массив типа double (вектор)
     * @return vectorRes - результат умножения матрицы на вектор в виде одномерного массива (вектора)
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] vectorRes = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                vectorRes[i] = vectorRes[i] + matrix[i][j] * vector[j];
            }
        }
        return vectorRes;
    }

    /**
     * Умножение матрицы размера M x N на матрицу размером M x K
     * @param matrixLeft - двумерный массив типа double (матрица)
     * @param matrixRight - двумерный массив типа double (матрица)
     * @return matrixRes - результат умножения матрицы на матрицу в виде двумерного массива (матрицы)
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] matrixRes = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    matrixRes[i][j] = matrixRes[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return matrixRes;
    }

    /**
     * Создание вектора и заполнение его рандомными числами
     * @param n - размерность (число элементов) одномерного массива (вектора)
     * @return vector - созданный и заполненный числами одномерный массив (вектор)
     */
    static double[] CreateVector(int n) {
        double[] vector = new double[n];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) ((Math.random() * 30) - 15);
        }
        return vector;
    }

    /**
     * Создание матрицы и заполнение её рандомными числами
     * @param n - размерность (число строк) двумерного массива(матрицы)
     * @param m - размерность (число столбцов) двумерного массива (матрицы)
     * @return matrix - созданный и заполненный числами двумерный массив (матрица)
     */
    static double[][] CreateMatrix(int n, int m) {
        double[][] matrix = new double[n][m];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = CreateVector(m);
        }
        return matrix;
    }


}