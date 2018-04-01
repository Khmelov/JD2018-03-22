package by.it.kirova.jd01_04;

//import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }


    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }


    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        System.out.println("Unsorted array:");
        String nn = "V";
        InOut.printArray(array, nn , 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        System.out.println("Sorted array:");
        InOut.printArray(array, "V", 4);
        System.out.println("Find new index:");
        // Arrays.binarySearch(array, first);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("last element=" + i);
                break;
            }
        }


    }
}
