package by.it.romankov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "N", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        System.out.println(Helper.findMax(array));
        Helper.sort(array);




    }
}
