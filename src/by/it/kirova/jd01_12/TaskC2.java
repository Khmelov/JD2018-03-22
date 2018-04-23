package by.it.kirova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    private static <T extends Number> Set<T> getUnion(Set<T>... a) {
        Set<T> result = new HashSet<>();
        for (Set<T> set : a) {
            result.addAll(set);
        }
        return result;
    }

    private static <T extends Number> Set<T> getCross(Set<T>... a) {
        Set<T> result = null;
        for (Set<T> set : a) {
            if (result == null)
                result = new HashSet<>(set);
            else
                result.retainAll(set);
        }
        return result;
    }


    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5, 12, 6, 7, 7, 68, 8));
        Set<Integer> b = new TreeSet<>(Arrays.asList(8, 9, 10, 14, 5, 5, 6, 6, 7, 7, 8));
        Set<Integer> c = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 11, 6, 6, 7, 77, 1, 8));
        Set<Integer> d = new TreeSet<>(Arrays.asList(8, 9, 10, 4, 5, 13, 6, 6, 7, 97, 8));
        Set<Integer> unionRes = getUnion(a, b, c, d);
        System.out.println("getUnion(a, b, c, d) result: " + unionRes);
        Set<Integer> crossRes = getCross(a, b, c);
        System.out.println("getCross(a, b, c) result: " + crossRes);
    }


}

