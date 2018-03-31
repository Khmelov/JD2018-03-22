package by.it.fando.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
        if (0==arr.length){
            return Double.MIN_VALUE;
        }
        else {
            double min=arr[0];
            for (double m : arr) {
                if (min>m) min=m;
            }
            return min;
        }


    }
    static double findMax(double[ ] arr){
        if (0==arr.length){
            return Double.MAX_VALUE;
        }
        else {
            double max=arr[0];
            for (double m : arr) {
                if (max<m) max=m;
            }
            return max;
        }

    }
    static void sort(double[ ] arr){
        boolean abc;
        double last=arr.length-1;
        do {
            abc = false;
            for (int j = 0; j < last; j++) {
                if (arr[j]>arr[j+1]){
                    double buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                    abc = true;
                }
            }
            last--;
        }
        while (abc);
        printMas(arr);
    }

     private static void printMas (double massive[]){
        for (double arr : massive) System.out.print(arr+" ");
        System.out.println();
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] a = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                a[i] = a[i] + matrix[i][j] * vector[j];
            return a;

    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] a = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    a[i][j] = a[i][j] + matrixLeft[i][k]*matrixRight[k][j];
        return a;
    }

}