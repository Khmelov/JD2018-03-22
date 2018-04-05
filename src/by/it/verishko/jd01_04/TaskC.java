package by.it.verishko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
        double[] m4 = {1, 3, 4, 2};
        mergeSort(m4);
        binarySearch(m4, 3);
    }

    static int binarySearch(double[ ] array, double value){
        return (int) value;
    }

    public static void mergeSort(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            double min = arr[i];
            double min_i = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                double tmp = arr[i];
                arr[i] = arr[(int) min_i];
                arr[(int) min_i] = tmp;
            }
        }
    }





//
//    static void mergeSort(double[ ] array){
//        Arrays.sort(array);
//    }




    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        System.out.println("Unsorted array");
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        System.out.println("Sorted array");
        InOut.printArray(array, "V", 4);
        System.out.println("Find new indexes");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
}
