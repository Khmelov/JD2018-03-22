package by.it.lyukovich.jd_01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        double[][] array2 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
        double[][] array3 = {{7.0,8.0,9.0},{6.0,5.0,4.0},{1.0,2.0,3.0}};
        double[] array4 = {4.0,5.0,7.0};
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        InOut.printMin(array);
        InOut.printMax(array);
        InOut.printSorted(array);
        System.out.println();
        InOut.printMulMM(array2,array3);
        InOut.printMulMV(array3,array4);
    }


}
