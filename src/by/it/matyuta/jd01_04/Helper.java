package by.it.matyuta.jd01_04;

import java.util.Arrays;

public class Helper {
    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    static void sort (double[] mas){
        Arrays.sort(mas);
    }
}

