package by.it.uskoryaev.jd01_12;

import java.util.*;

public class TaskA2 {


    private static Set<Integer> getCross(Set<Integer>a,Set<Integer>b){

        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;

    }
    private static Set<Integer> getUnion(Set<Integer>a,Set<Integer>b){

            Set<Integer> result = new HashSet<>();
            result.addAll(a);
            result.addAll(b);
            return result;
        }
    public static void main(String[] args) {
        Set<Integer> a  = new HashSet<>(Arrays.asList(1,2,3,4,5,6,8,7,8));
        Set<Integer> b  = new TreeSet<>(Arrays.asList(1,2,3,4,5,6,8,7,8,9,10));

        System.out.println(a);
        System.out.println(b);
        Set<Integer> c = getUnion(a,b);
        System.out.println(c);
    }
}
