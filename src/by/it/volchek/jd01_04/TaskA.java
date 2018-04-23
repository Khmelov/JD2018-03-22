package by.it.volchek.jd01_04;

import by.it.volchek.jd01_03.Helper;
import by.it.volchek.jd01_03.InOut;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by volchek on 29.03.18.
 */
public class TaskA {
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        System.out.println("Unsorted array");
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        System.out.println();
        System.out.println("Find new indexes");
        System.out.println("first element=" + Arrays.binarySearch(array, first));
        System.out.println("last element=" + Arrays.binarySearch(array, last));

    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
}
