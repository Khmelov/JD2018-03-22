package by.it.lyukovich.jd_01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s = scan.nextLine();
        buildOneDimArray(s);

    }
    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length-1];
        System.out.println(array.toString());
        InOut.printArray(array,"V",5);
        mergeSort(array);
        InOut.printArray(array,"V",4);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == start){
                System.out.println("Index of first element="+i);
                break;
            }

        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == stop){
                System.out.println("Index of last element="+i);
                break;
            }

        }



    }
    private static void mergeSort(double[ ] array){
        Arrays.sort(array);
    }
    static int binarySearch(double[ ] array, double value) {
        double start = array[0];
        double stop = array[array.length-1];
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value < array[mid]) high = mid - 1;
            else if (value > array[mid]) low = mid + 1;
            else return mid;
        }

        return -1;
    }
}
