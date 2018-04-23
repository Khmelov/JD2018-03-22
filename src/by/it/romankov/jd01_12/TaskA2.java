package by.it.romankov.jd01_12;

import java.util.*;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet <>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet <>(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args) {

        Set<Integer> a = new HashSet <>(Arrays.asList(11,2,3,44,5,6));
        Set<Integer> b = new TreeSet<>(Arrays.asList(44,5,16,7,48,9));
        System.out.println(a);
        System.out.println(b);
        Set<Integer> c =getUnion(a, b);
        System.out.println(c);
        Set<Integer> d =getCross(a, b);
        System.out.println(d);

    }


}
