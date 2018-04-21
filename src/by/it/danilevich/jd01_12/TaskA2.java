package by.it.danilevich.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {

        Set<Integer>a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8888, 97, 25, 23 , 14, 54, 68, 77));
        Set<Integer>b = new HashSet<>(Arrays.asList(0, -2, -3, 4, 5, 6, 7, 8888, -97, -25, -23 , -14, -54, -68, -77));
     //   Set<Integer>c = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8888, 97, 25, 23 , 14, 54, 68, 77));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        Set<Integer> c= getUnion(a, b);
        System.out.println("all elemements = " + c);
        Set<Integer> d = getCross(a,b);
        System.out.println(" cross elements" + d);

    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> rez= new HashSet<>();
        rez.addAll(a);
        rez.addAll(b);
        return rez;

    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> rez= new HashSet<>(a);
        rez.retainAll(b);
        return rez;
    }
}
