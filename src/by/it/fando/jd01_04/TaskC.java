package by.it.fando.jd01_04;

import java.util.Scanner;

public class TaskC {

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        System.out.println("Unsorted array");
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array,0,array.length-1);
        System.out.println("Sorted array");
        InOut.printArray(array, "V", 4);
        System.out.println("Find new indexes");
        System.out.println("Index of first element");
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



    private static double[] mergeSort(double[ ] array, int start, int finish) {

        if (start >= finish) return array;
        int i = start;
        int j = finish;
        int op = (i+j)/2;

        while (i<j) {
            while ((i<op) && (array[i]<=array[op])) i++;
            while ((j>op) && (array[j]>=array[op])) i--;

            if (i<j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == op) op = j;
                else if (j == op) op = i;

            }
        }

        mergeSort (array, start, op);
        mergeSort(array,op+1, finish);

        return array;
    }

    public static void main (String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        buildOneDimArray(line);

    }

}
