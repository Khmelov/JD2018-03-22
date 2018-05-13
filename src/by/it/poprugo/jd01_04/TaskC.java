package by.it.poprugo.jd01_04;

import java.util.Scanner;

public class TaskC {
    private static void mergeSort(double[] array) {
        mergeSortRecursive(array, 0, array.length);
    }

    private static void mergeSortRecursive(double[] arrMer, int left, int right) {
        if ((left + 1) < right) {
            int middle = (left + right) / 2;
            mergeSortRecursive(arrMer, left, middle);
            mergeSortRecursive(arrMer, middle, right);
            merge(arrMer, left, middle, right);
        }
    }

    private static void merge(double[] a, int left, int mid, int right) {
        int ind1 = 0;
        int ind2 = 0;
        double[] arrBuff = new double[(right - left)];
        while ((left + ind1) < mid && ((mid + ind2) < right)) {
            if (a[left + ind1] < a[mid + ind2]) {
                arrBuff[ind1 + ind2] = a[left + ind1];
                ind1++;
            } else {
                arrBuff[ind1 + ind2] = a[mid + ind2];
                ind2++;
            }
        }
        while ((left + ind1) < mid) {
            arrBuff[ind1 + ind2] = a[left + ind1];
            ind1++;
        }
        while ((mid + ind2) < right) {
            arrBuff[ind1 + ind2] = a[mid + ind2];
            ind2++;
        }
        for (int i = 0; i < ind1 + ind2; i++) {
            a[left + i] = arrBuff[i];
        }
        //return a;
    }

    private static int binarySearch(double[] array, double value) {
        int ind = -1;
        if (array != null) {
            int low = 0, high = array.length, center;
            while (low < high) {
                center = (low + high) / 2; //(low+high)>>>1 to avoid > MAX_INTEGER
                if (value == array[center]) {
                    ind = center;
                    break;
                } else {
                    if (value < array[center]) high = center;
                    else low = ++center;
                }
            }
        }
        return ind;
    }

    private static void buildOneDimArray(String line) {
        double[] arrD = InOut.getArray(line);
        System.out.println("Unsorted array");
        InOut.printArray(arrD, "V", 5);
        double first = arrD[0];
        double last = arrD[arrD.length - 1];
        //Helper.sort(arrD);
        mergeSort(arrD);
        System.out.println("\nSorted array");
        InOut.printArray(arrD, "V", 4);
        System.out.println("Find new indexes");
        System.out.println("Index of first element=" + binarySearch(arrD, first));
        System.out.println("Index of last element=" + binarySearch(arrD, last));
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input double array in line");
        String strArr = sc.nextLine();
        //String strArr = "5 5.3 0 0.1 0.2 3 3.5 3.3";
        buildOneDimArray(strArr);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }
}