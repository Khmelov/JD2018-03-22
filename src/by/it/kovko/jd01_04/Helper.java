package by.it.kovko.jd01_04;
/**
 * @autor E. Kovko
 */

import java.util.Random;

public class Helper {
    static double findMin(double[ ] arr){
        double min=Double.MAX_VALUE;
        for (double x: arr)
            min=(x<min)?x:min;
        return min;
    }

    static double findMax(double[ ] arr){
        double max=Double.MIN_VALUE;
        for (double x: arr)
            max=(x>max)?x:max;
        return max;
    }
    static void sort(double[ ] arr){
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
     * @param min Нижняя граница случайного числа
     * @param max Верхняя граница случайного числа
     * @param rows Количество строк матрицы
     * @param cols Количество столбцов матрицы
     * @return Метод возвращаяет матрицу заданного размера
     */
    static double[][] randomMatrix(double min, double max, int rows, int cols){
        double rMatrix[][] = new double[rows][cols];
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rMatrix[i][j]=min+Math.abs(max-min)*r.nextDouble();
            }
        }
        return rMatrix;
    }

    /**
     *
     * @param min Нижняя граница случайного числа
     * @param max Верхняя граница случайного числа
     * @param rows Количество строк вектора
     * @return
     */
    static double[] randomVector(double min, double max, int rows){
        double randomVector[] = new double[rows];
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            randomVector[i]=min+Math.abs(max-min)*r.nextDouble();
        }

        return randomVector;
    }

    static double[ ] mul(double[][] matrix, double[] vector){
        double result[] = new double[matrix.length];
        for (int i=0;i<matrix.length;++i){
            for (int j=0; j<matrix[i].length; ++j){
                result[i]+=matrix[i][j]*vector[j];
            }
        }
        return result;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double result[][]= new double [matrixLeft.length][matrixRight[0].length];
        for (int i=0;i<matrixLeft.length;++i){
            for (int j=0;j<matrixRight[0].length;++j){
                for (int m=0;m<matrixRight.length;++m){
                    result[i][j]+=matrixLeft[i][m]*matrixRight[m][j];
                }
            }
        }
        return result;
    }

}
