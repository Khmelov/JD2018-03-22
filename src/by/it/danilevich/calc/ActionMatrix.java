package by.it.danilevich.calc;

public class ActionMatrix {
    /*static double findMin(double[ ] arr){
      double min = Double.MAX_VALUE;
       for (double elem: arr) {
           if (elem < min) min = elem;
       }
       return min;
   }
   static double findMax(double[ ] arr){
          double max = Double.MIN_VALUE;
       for (double elem: arr) {
           if (elem > max) max = elem;

       }
       return max;
   }
   static double[] sort(double[ ] arr){
   //по возрастанию
       int dlina = arr.length;
       while (dlina > 0) {
           for (int i = 0; i < (dlina-1); i++) {
               if (arr[i] > arr[i+1]) {
                   double vrem = arr[i];
                   arr[i] = arr[i+1];
                   arr[i+1] = vrem;
               }
             }
           dlina = dlina - 1;
       }
       //InOut.printArray(arr);
       return arr;
   }
*/
    static double mulToSum(double[] matr1, double[] matr2){
        double sum =0;
        for (int i = 0; i < matr1.length; i++) {
            sum = sum + matr1[i]*matr2[i];
        }
        return sum;
    }
    static double[ ][] add(double[ ][ ] matrix1, double[ ][] matrix2){
        double[][] newMas = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                newMas[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return newMas;
    }
    static double[][] add(double[ ][ ] matrix1, double scalar){
        double[][] newMas = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                newMas[i][j] = matrix1[i][j] + scalar;
            }
        }
        return newMas;
    }

    static double[ ][] sub(double[ ][ ] matrix1, double[ ][] matrix2){
        double[][] newMas = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                newMas[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return newMas;
    }

    static double[][] sub(double[ ][ ] matrix1, double scalar){
        double[][] newMas = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                newMas[i][j] = matrix1[i][j] - scalar;
            }
        }
        return newMas;
    }

    static double[][] mul(double scalar, double[][] matrix){
        double[][] newMas = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMas[i][j] = matrix[i][j] * scalar;
            }
        }
        return newMas;
    }

    static double[] mul(double scalar, double[] matrix){
        double[] newMas = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            newMas[i] = matrix[i] * scalar;
        }
        return newMas;
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] newMas = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            double[] vrem = matrix[i];
            newMas[i] = mulToSum(vrem,vector);
        }
        return newMas;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        //умножаем строку на столбец
        if (!checkMatrixForMult(matrixLeft,matrixRight)) return null;
        double[][] newMas = new double[matrixLeft.length][matrixRight[0].length];
        for (int i= 0; i < matrixLeft.length; i++) {
            double[] matr1 = matrixLeft[i];
            for (int j = 0; j < matrixRight[0].length; j++) {
                //получим матрицу из элементов столбца
                double[] matr2 = new double[matrixRight.length];
                for (int k = 0; k < matrixRight.length; k++) {
                    matr2[k] = matrixRight[k][j];
                }
                double sum = mulToSum(matr1, matr2);
                newMas[i][j] = sum;
            }
        }
        return newMas;
    }
    /*static int findIndexElementa(double[] mas, double elem){
        int ind=-1;
        for (int i = 0; i < mas.length; i++) {
            if (elem==mas[i]) {
                ind = i;
                break;
            }
        }
        return ind;
    }
*/
    private static boolean checkMatrixForMult(double[][] matrixLeft, double[][] matrixRight){
        //count column in Matrix1== count line in Matrix2
        if (matrixLeft.length!=0 &&matrixRight.length!=0){
            if (matrixLeft[0].length==matrixRight.length) {
                return true;
            }
            else System.out.println("Count of column matrix left not equal count of line matrix right");
        }
        else  System.out.println("Empty matrix!");
        return false;
    }
}