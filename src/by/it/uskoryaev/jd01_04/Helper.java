package by.it.uskoryaev.jd01_04;


class Helper {
    static double findMin(double[] arr) {
        sort(arr);
        double min = arr[0];
        for (double elementMas : arr) {
            if (min > elementMas) min = elementMas;
        }
        return min;
    }

    static double findMax(double[] arr) {
        sort(arr);
        double max = arr[0];
        for (double elementMas : arr) {
            if (max < elementMas) max = elementMas;
        }
        return max;
    }

    static void sort(double[] arr) {
//      Внешний цикл каждый раз сокращает фрагмент массива,
//      так как внутренний цикл каждый раз ставит в конец
//      фрагмента максимальный элемент
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
//            Сравниваем элементы попарно,
//              если они имеют неправильный порядок,
//              то меняем местами
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * @param matrix
     * @param vector
     * @author Uskoryaev Alexey Victorovich
     * @version 1.5
     * @retern array result
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    /**
     * @param matrixLeft
     * @param matrixRight
     * @author Uskoryaev Alexey Victorovich
     * @version 2018-03-22
     * @retern array result
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixLeft.length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result;
    }
}