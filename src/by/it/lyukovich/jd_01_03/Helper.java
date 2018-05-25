package by.it.lyukovich.jd_01_03;

import java.util.Arrays;

public class Helper {
    /**
     * @author Anton Liukovich
     * @param arr - Входной массив данных
     * @return Возвращает минимальный элемент массива
     */
    static double findMin(double[ ] arr){
        double min=Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
               for (double element : arr) {
            if (min>element) min=element;
            if(max<element) max=element;
        }
        return min;

    }
    /**
     * @author Anton Liukovich
     * @param arr - Входной массив данных
     * @return Возвращает максимальный элемент массива
     */
    static double findMax(double[ ] arr){
        double min=Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (min>element) min=element;
            if(max<element) max=element;
        }
        return max;
    }
    /**
     * @author Anton Liukovich
     * @param arr - Входной массив данных
    */
    public static void sort(double[ ] arr){
        boolean swap=true;
        int size=arr.length-1;
        while (swap){
            swap=false;
            for (int i=0;i<size;++i){
                if (arr[i]>arr[i+1]){
                    double temp=arr[i]; arr[i]=arr[i+1]; arr[i+1]=temp;
                    swap=true;
                }
            }
            --size;
        }

    }
    /**
     * @author Anton Liukovich
     * @param matrix - Входная матрица
     * @param vector - Входной вектор
     * @return Возвращает новый вектор после умножения
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] newVektor= new double[0];
        if (matrix[0].length == vector.length){
            for (int i = 0; i < matrix.length; i++) {
                newVektor= Arrays.copyOf(newVektor, newVektor.length+1);
                double sum=0;
                for (int j = 0; j < matrix[i].length; j++) {
                    sum+=matrix[i][j]*vector[j];
                }
                newVektor[i] = sum;
            }
        }
        return newVektor;
    }
    /**
     * @author Anton Liukovich
     * @param matrixLeft - Входная матрица
     * @param matrixRight - Входной матрица
     * @return Возвращает новую матрицу после умножения
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] newMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newMatrix[i][j] = newMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return newMatrix;
    }

}
