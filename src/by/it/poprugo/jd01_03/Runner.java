package by.it.poprugo.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine(); //sc.nextLine().var - magic
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "v", 3);

        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);

        double[][] a1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[] a2 = {7, 8, 9};
        double[][] a3 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        double[] am1;
        double[][] am3;
        am1=Helper.mul(a1, a2);
        am3=Helper.mul(a1, a3);

    }
}
