package by.it.sgolovach.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array);
        System.out.println("V[1]=" + array[0] + " first element=" + binarySearch(array, first));
        System.out.println("V[" + array.length + "]=" + array[array.length - 1] + " last element=" + binarySearch(array, last));
    }


    static void mergeSort(double[] array) {
        System.arraycopy(mergeSort(array, 0, array.length - 1), 0, array, 0, array.length);
    }


    private static double[] mergeSort(double[] array, int left, int right) {
        int a = right - left + 1;

        if (a == 1) return new double[]{array[left]};
        if (a == 2) {
            if (array[left] < array[right]) return new double[]{array[left], array[right]};
            return new double[]{array[right], array[left]};
        }

        int mid = (right - left + 1) / 2;

        double[] part1 = mergeSort(array, left, left + mid - 1);
        double[] part2 = mergeSort(array, left + mid, right);

        return merge(part1, part2);
    }


    private static double[] merge(double[] part1, double[] part2) {
        double[] arr = new double[part1.length + part2.length];
        int a = 0, b = 0;
        int k = part1.length + part2.length;
        for (int i = 0; i < k; i++) {
            if (b < part2.length && a < part1.length) {
                if (part1[a] > part2[b]) arr[i] = part2[b++];
                else arr[i] = part1[a++];
            } else if (b < part2.length) {
                arr[i] = part2[b++];
            } else {
                arr[i] = part1[a++];
            }
        }
        return arr;
    }


    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) return mid;
            else if (array[mid] > value) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }


    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String line = scaner.nextLine();
        buildOneDimArray(line);
    }
}
