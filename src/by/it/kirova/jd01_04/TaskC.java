package by.it.kirova.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }


    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        System.out.println("Unsorted array:");
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        System.out.println("First element unsorted array: " + array[0]);
        System.out.println("Last element unsorted array: " + array[array.length - 1]);
        mergeSort(array);
        System.out.println("Sorted array:");
        InOut.printArray(array);
        int firstIndex = binarySearch(array, first);
        int lastIndex = binarySearch(array, last);
        System.out.println("first element=" + firstIndex);
        System.out.println("last element=" + lastIndex);

//        System.out.println("Sorted array:");
//        System.out.println("Find new index:");
//        // Arrays.binarySearch(array, first);
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == first) {
//                System.out.println("first element=" + i);
//                break;
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == last) {
//                System.out.println("last element=" + i);
//                break;
//            }
//        }
    }

    private static void mergeSort(double[] array) {
        int l = 0;
        int r = array.length - 1;
        double[] temp = mergeSort(array, l, r);
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }

    }


    private static double[] mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            double[] part1 = mergeSort(array, left, middle);
            double[] part2 = mergeSort(array, middle + 1, right);
            return merge(part1, part2);
        }
        double[] single = new double[1];
        single[0] = array[left];
        return single;
    }


    private static double[] merge(double[] part1, double[] part2) {
        int n1 = part1.length;
        int n2 = part2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        double[] array = new double[n1 + n2];
        while (i < n1 && j < n2) {
            if (part1[i] <= part2[j]) {
                array[k] = part1[i];
                i++;
            } else {
                array[k] = part2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = part1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = part2[j];
            j++;
            k++;
        }
        return array;
    }


    private static int binarySearch(double[] array, double value) {
        int l = 0;
        int r = array.length;

        while (l <= r) {
            int m = (l + r) / 2;
            if (value == array[m])
                return m;
            else if (value > array[m])
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;

    }


}


