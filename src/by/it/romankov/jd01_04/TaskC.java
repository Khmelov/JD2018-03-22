package by.it.romankov.jd01_04;

import java.util.Arrays;

public class TaskC {
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);

        System.out.println("Unsorted array");
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length-1];

        Arrays.sort(array);
        System.out.println("Sorted array");
        InOut.printArray(array, "V", 4);
        System.out.println("Find new indexes");

        for ( int i = 0; i < array.length; i++ ) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for ( int i = 0; i < array.length; i++ ) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

}
