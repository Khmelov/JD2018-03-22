package by.it.kovko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {

    @SafeVarargs
    private static <T extends Number> Set<T> getUnion(Set<T> ... a){
        Set<T> result = new HashSet<>();
        for (Set<T> set : a) result.addAll(set);
        return result;
    }
    @SafeVarargs
    private static <T extends Number> Set<T> getCross(Set<T> ... a){
        Set<T> result = new HashSet<>();
        for (Set<T> set : a) result.retainAll(set);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> a= new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8));
        Set<Integer> b= new TreeSet<>(Arrays.asList(8,9,10, 5, 5, 6, 6, 7, 7, 8, 8,1));
        Set<Integer> c = new TreeSet<>(Arrays.asList(8,9,10, 5, 5, 6, 6, 7, 7, 8, 8,41,32,12,1));
        System.out.println(a);
        System.out.println(b);
        System.out.println();
        Set<Integer> d = getUnion(b,c,a);
        Set<Integer> m = getCross(a,b,c);
        System.out.println(d);
        System.out.println(m);
    }
}
