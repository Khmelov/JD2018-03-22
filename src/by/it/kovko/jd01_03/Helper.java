package by.it.kovko.jd01_03;

import java.util.Random;
/**
 * Class with useful methods
 */
public class Helper {

    /**
     *  Search of the element with a minimal value
     * @param arr Input array
     * @return Index of the element
     */
    static double findMin(double[ ] arr){
        double min=Double.MAX_VALUE;
        for (double x: arr)
            min=(x<min)?x:min;
        return min;
    }

    /**
     *  Search of the element with a maximum value
     * @param arr Input array
     * @return Index of the element
     */
    static double findMax(double[ ] arr){
        double max=Double.MIN_VALUE;
        for (double x: arr)
            max=(x>max)?x:max;
        return max;
    }

    /**
     * Bubbles sorting
     * @param arr Input array
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
     * Creating of matrix filled with random numbers in some range
     * @param min Lower border of random number
     * @param max Upper border of random number
     * @param rows Number of rows in the matrix
     * @param cols Number of columns in the matrix
     * @return Return a matrix with certain parameters
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
     * Creating or array filled with random numbers in some range
     * @param min Lower border of random number
     * @param max Upper border of random number
     * @param rows Number of elements in the array
     * @return Returning an array
     */
    static double[] randomVector(double min, double max, int rows){
        double randomVector[] = new double[rows];
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            randomVector[i]=min+Math.abs(max-min)*r.nextDouble();
        }

        return randomVector;
    }

    /**
     * Multiplications of a matrix by a vector
     * @param matrix Input matrix
     * @param vector INput vector
     * @return Result vector
     */
    static double[ ] mul(double[][] matrix, double[] vector){
        double result[] = new double[matrix.length];
        for (int i=0;i<matrix.length;++i){
            for (int j=0; j<matrix[i].length; ++j){
                result[i]+=matrix[i][j]*vector[j];
            }
        }
        return result;
    }

    /**
     * Multiplications of matrixs
     * @param matrixLeft Left matrix
     * @param matrixRight Right matrix
     * @return Result matrix
     */
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
