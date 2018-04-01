package by.it.uskoryaev.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"v",3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double [] [] mas1 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        double [] mas2 = {1.0,2.0,3.0};
        double [] [] mas3 = mas1;

        Helper.mul(mas1,mas2);
        Helper.mul(mas1,mas3);
    }

}
