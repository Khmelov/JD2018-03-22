package by.it.kovko.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String arr="12.9 324.3 13.1 2.543 12.32";
        double[] mas=InOut.getArray(arr);
        InOut.printArray(mas);
        InOut.printArray(mas,"m",2);
        System.out.println("Минимальное значение" + Helper.findMin(mas));
        System.out.println("Максимальное значение" + Helper.findMax(mas));
        double[] unsortedVector=Helper.randomVector(-10,10,5);
        System.out.println(Arrays.toString(unsortedVector));
        Helper.sort(unsortedVector);
        System.out.println(Arrays.toString(unsortedVector));
        double[][] newRandomMatrix, newRandomMatrix2;
        newRandomMatrix=Helper.randomMatrix(-10,10,5,5);
        newRandomMatrix2=Helper.randomMatrix(-10,10,5,5);
        double[] newRandomVector;
        newRandomVector=Helper.randomVector(-10,10,5);
        System.out.println("Матрица со случайными числами");
        for (double[] randomLine : newRandomMatrix) {
            System.out.println(Arrays.toString(randomLine));
        }
        System.out.println("Вектор со случайными числами");
        System.out.println(Arrays.toString(newRandomVector));
        double[] resultVxM= new double[5];
        resultVxM=Helper.mul(newRandomMatrix,newRandomVector);
        double[][] resultMxM= new double[5][5];
        resultMxM=Helper.mul(newRandomMatrix,newRandomMatrix2);

    }
}
