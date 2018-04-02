package by.it.kovko.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String arr="12.9 324.3 13.1 2.543 12.32";
        double[] mas=InOut.getArray(arr);
        String name="m";
        double min=-10, max=10;
        int rows=5, cols=2;
        InOut.printArray(mas);
        InOut.printArray(mas,name,cols);
        System.out.println("Минимальное значение" + Helper.findMin(mas));
        System.out.println("Максимальное значение" + Helper.findMax(mas));
        double[] unsortedVector=Helper.randomVector(min,max,rows);
        System.out.println(Arrays.toString(unsortedVector));
        Helper.sort(unsortedVector);
        System.out.println(Arrays.toString(unsortedVector));
        double[][] newRandomMatrix, newRandomMatrix2;
        newRandomMatrix=Helper.randomMatrix(min,max,rows,rows);
        newRandomMatrix2=Helper.randomMatrix(min,max,rows,rows);
        double[] newRandomVector;
        newRandomVector=Helper.randomVector(min,max,rows);
        System.out.println("Матрица со случайными числами");
        for (double[] randomLine : newRandomMatrix) {
            System.out.println(Arrays.toString(randomLine));
        }
        System.out.println("Вектор со случайными числами");
        System.out.println(Arrays.toString(newRandomVector));

        double[] resultVxM;
        resultVxM=Helper.mul(newRandomMatrix,newRandomVector);
        System.out.println("Result vector"+ Arrays.toString(resultVxM));

        double[][] resultMxM;
        resultMxM=Helper.mul(newRandomMatrix,newRandomMatrix2);
        System.out.println("Result matrix");
        for (double[] resLine : resultMxM) {
            System.out.println(Arrays.toString(resLine));
        }
        System.out.println();


    }
}
