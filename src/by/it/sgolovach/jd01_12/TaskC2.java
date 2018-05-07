package by.it.sgolovach.jd01_12;

import java.util.*;

public class TaskC2 {

    private static <T extends Number> Set<T> getUnion(Set<T>... a) {
        Set<T> result = new HashSet<>();
        for (Set<T> ts : a) {
            result.addAll(ts);
        }

        return result;
    }

    private static <T extends Number> Set<T> getCross(Set<T>... a) {
        Set<T> result = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            result = a[0];
            result.retainAll(a[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 5, 3, 5, 2, 2, 8, 5, 4, 5, 6, 5, 5, 8, 8));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 3, 5, 2, 2, 10, 5, 5, 7, 9, 5, 5, 8, 8));
        Set<Integer> d = new HashSet<>(Arrays.asList(2, 3, 10, 15));

        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        Set<Integer> c = getUnion(a, b, d);
        System.out.println(c);
        Set<Integer> e = getCross(a, b, d);
        System.out.println(e);
        ArrayList<Double> ad = new ArrayList<>();
        for (double i = 0; i < 5; i += 0.5) {
            ad.add((double) i);
        }

        ArrayList<Double> ad1 = new ArrayList<>();
        for (double i = 3; i < 5; i += 0.5) {
            ad1.add((double) i);
        }
        ArrayList<Double> ad2 = new ArrayList<>();
        for (double i = 1; i < 4; i += 0.5) {
            ad2.add((double) i);
        }
        Set<Double> dob = new TreeSet<>(ad);
        Set<Double> dob1 = new TreeSet<>(ad1);
        Set<Double> dob2 = new TreeSet<>(ad2);
        System.out.println(dob);
        System.out.println(dob1);
        System.out.println(dob2);
        Set<Double> resd1 = getUnion(dob,dob1,dob2);
        System.out.println(resd1);
        Set<Double> resd2 = getCross(dob,dob1,dob2);
        System.out.println(resd2);

    }
}
